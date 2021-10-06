package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.SellerServiceExpection;
import com.project.Request.ModifyRequest;
import com.project.Request.SubCatagoryRequest;
import com.project.Response.Response;
import com.project.Response.SubCatagoryResponse;
import com.project.Service.SubCatagoryService;

@RestController
@RequestMapping("/subCatagory/")
public class SubCatagoryController {

	@Autowired
	private SubCatagoryService subCatagoryService;

	@RequestMapping(value = "getSubCatagories", method = RequestMethod.GET, produces = "application/json")
	public SubCatagoryResponse getSubCatagories() {

		SubCatagoryResponse response = subCatagoryService.getSubCatagories();
		return response;
	}

	@RequestMapping(value = "addSubCatagory", method = RequestMethod.POST, produces = "application/json")
	public Response addSubCatagory(@RequestBody SubCatagoryRequest request,
			@RequestHeader(value = "userId") Integer userId) throws SellerServiceExpection {
		request.setUserId(userId);
		Response response = subCatagoryService.addSubCatagory(request);
		return response;
	}

	@RequestMapping(value = "editSubCatagory", method = RequestMethod.POST, produces = "application/json")
	public Response editSubCatagory(@RequestBody SubCatagoryRequest request,
			@RequestHeader(value = "userId") Integer userId) throws SellerServiceExpection {
		request.setUserId(userId);

		Response response = subCatagoryService.addSubCatagory(request);
		return response;
	}

	@RequestMapping(value = "deleteSubCatagory", method = RequestMethod.POST)
	public @ResponseBody Response deleteSubCatagory(@RequestBody ModifyRequest request,
			@RequestHeader("userid") Integer userId) throws SellerServiceExpection {

		request.setUserId(userId);

		Response response = subCatagoryService.deleteSubCatagory(request);
		return response;
	}
}
