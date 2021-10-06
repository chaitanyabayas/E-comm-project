package com.project.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.CatagoryDAO;
import com.project.Dto.CatagoryDTO;
import com.project.Exception.SellerServiceExpection;
import com.project.Model.Catagory;
import com.project.Request.CatagoryRequest;
import com.project.Request.ModifyRequest;
import com.project.Response.CatagoryResponse;
import com.project.Response.Response;
import com.project.SellerService.ResponseStatus;
import com.project.Service.CatagoryService;

@Service
public class CatagoryServiceImpl implements CatagoryService {

	@Autowired
	private CatagoryDAO catagoryDAO;

	@Override
	public CatagoryResponse getCatagories() {
		CatagoryResponse response = new CatagoryResponse();

		List<Catagory> catagories = catagoryDAO.findAllCatagory();
		List<CatagoryDTO> catagoriesDTO = new ArrayList<CatagoryDTO>();

		for (Catagory catagorie : catagories) {
			CatagoryDTO dto = new CatagoryDTO(catagorie);
			dto.setId(catagorie.getId());
			dto.setCatagoryName(catagorie.getCatagoryName());
			catagoriesDTO.add(dto);
		}

		response.setStatus(ResponseStatus.OK);
		response.setMessage("Catagory Fetched!");
		response.setCatagoryDTO(catagoriesDTO);
		return response;
	}

	@Override
	public Response addCatagory(CatagoryRequest request) throws SellerServiceExpection {

		Response response = new Response();

		if (request.getCatagoryName() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Catagory Name is Required");
		}

		Catagory cat = catagoryDAO.findByCatagoryName(request.getCatagoryName());
		if (cat != null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Catagory already exsists.");
		}

		Catagory catagoryDetails = null;

		if (request.getId() != null) {
			catagoryDetails = catagoryDAO.findCatagoryById(request.getId());
		}

		if (catagoryDetails == null) {
			catagoryDetails = new Catagory();
			catagoryDetails.setCatagoryName(request.getCatagoryName());

			catagoryDetails.setCreatedBy(request.getUserId());
			catagoryDetails.setCreatedDate(LocalDateTime.now());
			catagoryDetails.setUpdatedBy(request.getUserId());
			catagoryDetails.setUpdatedDate(LocalDateTime.now());
			catagoryDetails.setActive(true);

		} else {
			catagoryDetails.setCatagoryName(request.getCatagoryName());

			catagoryDetails.setUpdatedBy(request.getUserId());
			catagoryDetails.setUpdatedDate(LocalDateTime.now());
			catagoryDetails.setActive(true);
		}

		catagoryDAO.save(catagoryDetails);

		response.setStatus(ResponseStatus.OK);
		if (request.getId() == null) {
			response.setMessage("Catagory Saved Successfully.");
		} else {
			response.setMessage("Catagory Updated Successfully.");
		}
		return response;
	}

	@Override
	public Response deleteCatagory(ModifyRequest request) throws SellerServiceExpection {

		Response response = new Response();

		Catagory catagoryDetails = catagoryDAO.findCatagoryById(request.getId());

		if (catagoryDetails == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Data Not Present with given Details!");
		}

		catagoryDetails.setActive(false);
		catagoryDetails.setUpdatedBy(request.getUserId());
		catagoryDetails.setUpdatedDate(LocalDateTime.now());

		catagoryDAO.save(catagoryDetails);

		response.setStatus(ResponseStatus.OK);
		response.setMessage("Catagory Deleted Successfully!");

		return response;
	}

}
