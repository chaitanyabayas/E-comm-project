package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.SellerServiceExpection;
import com.project.Request.CatagoryRequest;
import com.project.Request.ModifyRequest;
import com.project.Response.CatagoryResponse;
import com.project.Response.Response;
import com.project.Service.CatagoryService;

@RestController
@RequestMapping("/catagory/")
public class CatagoryController {

	@Autowired
	private CatagoryService catagoryService;

	@RequestMapping(value = "getCatagories", method = RequestMethod.GET, produces = "application/json")
	public CatagoryResponse getCatagories() {

		CatagoryResponse response = catagoryService.getCatagories();
		return response;
	}

	@RequestMapping(value = "addCatagory", method = RequestMethod.POST, produces = "application/json")
	public Response addCatagory(@RequestBody CatagoryRequest request, @RequestHeader(value = "userId") Integer userId)
			throws SellerServiceExpection {
		request.setUserId(userId);

		Response response = catagoryService.addCatagory(request);
		return response;
	}

	@RequestMapping(value = "editCatagory", method = RequestMethod.POST, produces = "application/json")
	public Response editCatagory(@RequestBody CatagoryRequest request, @RequestHeader(value = "userId") Integer userId)
			throws SellerServiceExpection {
		request.setUserId(userId);

		Response response = catagoryService.addCatagory(request);
		return response;
	}

	@RequestMapping(value = "deleteCatagory", method = RequestMethod.POST)
	public @ResponseBody Response deleteCatagory(@RequestBody ModifyRequest request,
			@RequestHeader("userId") Integer userId) throws SellerServiceExpection {

		request.setUserId(userId);

		Response response = catagoryService.deleteCatagory(request);
		return response;
	}

}
