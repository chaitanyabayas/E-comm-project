package com.project.Service;

import com.project.Exception.SellerServiceExpection;
import com.project.Request.ModifyRequest;
import com.project.Request.SubCatagoryRequest;
import com.project.Response.Response;
import com.project.Response.SubCatagoryResponse;

public interface SubCatagoryService {

	Response addSubCatagory(SubCatagoryRequest request) throws SellerServiceExpection;

	Response deleteSubCatagory(ModifyRequest request) throws SellerServiceExpection;

	SubCatagoryResponse getSubCatagories();

}
