package com.project.Service;

import com.project.Exception.SellerServiceExpection;
import com.project.Request.CatagoryRequest;
import com.project.Request.ModifyRequest;
import com.project.Response.CatagoryResponse;
import com.project.Response.Response;

public interface CatagoryService {

	Response addCatagory(CatagoryRequest request) throws SellerServiceExpection;

	Response deleteCatagory(ModifyRequest request) throws SellerServiceExpection;

	CatagoryResponse getCatagories();

}
