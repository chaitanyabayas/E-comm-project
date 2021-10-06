package com.project.Service;

import com.project.Exception.SellerServiceExpection;
import com.project.Request.ModifyRequest;
import com.project.Request.ProductRequest;
import com.project.Response.ProductResponse;
import com.project.Response.Response;

public interface ProductService {

	Response addProduct(ProductRequest request) throws SellerServiceExpection;

	Response deleteProduct(ModifyRequest request) throws SellerServiceExpection;

	ProductResponse getProducts();

}
