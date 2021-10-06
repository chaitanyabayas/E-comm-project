package com.project.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.SubCatagoryDAO;
import com.project.Dto.SubCatagoryDTO;
import com.project.Exception.SellerServiceExpection;
import com.project.Model.SubCatagory;
import com.project.Request.ModifyRequest;
import com.project.Request.SubCatagoryRequest;
import com.project.Response.Response;
import com.project.Response.SubCatagoryResponse;
import com.project.SellerService.ResponseStatus;
import com.project.Service.SubCatagoryService;

@Service
public class SubCatagoryServiceImpl implements SubCatagoryService {

	@Autowired
	private SubCatagoryDAO subCatagoryDAO;

	@Override
	public SubCatagoryResponse getSubCatagories() {
		SubCatagoryResponse response = new SubCatagoryResponse();

		List<SubCatagory> subCatagorys = subCatagoryDAO.findAllSubCatagory();
		List<SubCatagoryDTO> subCatagoryDTO = new ArrayList<SubCatagoryDTO>();

		for (SubCatagory subCatagory : subCatagorys) {
			SubCatagoryDTO dto = new SubCatagoryDTO(subCatagory);
			dto.setId(subCatagory.getId());
			dto.setSubCatagoryName(subCatagory.getSubCatagoryName());
			subCatagoryDTO.add(dto);
		}

		response.setStatus(ResponseStatus.OK);
		response.setMessage("Sub Catagory Fetched!");
		response.setSubCatagoryDTO(subCatagoryDTO);
		return response;
	}

	@Override
	public Response addSubCatagory(SubCatagoryRequest request) throws SellerServiceExpection {

		Response response = new Response();

		if (request.getSubCatagoryName() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Sub Catagory Name is Required");
		}

		SubCatagory subCat = subCatagoryDAO.findBySubCatagoryName(request.getSubCatagoryName());
		if (subCat != null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Sub Catagory already exsists.");
		}

		SubCatagory subCatagoryDetails = null;

		if (request.getId() != null) {
			subCatagoryDetails = subCatagoryDAO.findSubCatagoryById(request.getId());
		}

		if (subCatagoryDetails == null) {
			subCatagoryDetails = new SubCatagory();
			subCatagoryDetails.setSubCatagoryName(request.getSubCatagoryName());

			subCatagoryDetails.setCreatedBy(request.getUserId());
			subCatagoryDetails.setCreatedDate(LocalDateTime.now());
			subCatagoryDetails.setUpdatedBy(request.getUserId());
			subCatagoryDetails.setUpdatedDate(LocalDateTime.now());
			subCatagoryDetails.setActive(true);

		} else {
			subCatagoryDetails.setSubCatagoryName(request.getSubCatagoryName());

			subCatagoryDetails.setUpdatedBy(request.getUserId());
			subCatagoryDetails.setUpdatedDate(LocalDateTime.now());
			subCatagoryDetails.setActive(true);
		}

		subCatagoryDAO.save(subCatagoryDetails);

		response.setStatus(ResponseStatus.OK);
		if (request.getId() == null) {
			response.setMessage("SubCatagory Saved Successfully.");
		} else {
			response.setMessage("SubCatagory Updated Successfully.");
		}
		return response;
	}

	@Override
	public Response deleteSubCatagory(ModifyRequest request) throws SellerServiceExpection {

		Response response = new Response();

		SubCatagory subCatagoryDetails = subCatagoryDAO.findSubCatagoryById(request.getId());

		if (subCatagoryDetails == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Data Not Present with given Details!");
		}

		subCatagoryDetails.setActive(false);
		subCatagoryDetails.setUpdatedBy(request.getUserId());
		subCatagoryDetails.setUpdatedDate(LocalDateTime.now());

		subCatagoryDAO.save(subCatagoryDetails);

		response.setStatus(ResponseStatus.OK);
		response.setMessage("Sub Catagory Deleted Successfully!");

		return response;
	}

}
