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
import com.project.Request.ProductRequest;
import com.project.Response.ProductResponse;
import com.project.Response.Response;
import com.project.Service.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "getProducts", method = RequestMethod.GET, produces = "application/json")
	public ProductResponse getProducts() {

		ProductResponse response = productService.getProducts();
		return response;
	}

	@RequestMapping(value = "addProduct", method = RequestMethod.POST, produces = "application/json")
	public Response addProduct(@RequestBody ProductRequest request, @RequestHeader(value = "userId") Integer userId)
			throws SellerServiceExpection {
		request.setUserId(userId);

		Response response = productService.addProduct(request);
		return response;
	}

	@RequestMapping(value = "editProduct", method = RequestMethod.POST, produces = "application/json")
	public Response editProduct(@RequestBody ProductRequest request, @RequestHeader(value = "userId") Integer userId)
			throws SellerServiceExpection {
		request.setUserId(userId);

		Response response = productService.addProduct(request);
		return response;
	}

	@RequestMapping(value = "deleteProduct", method = RequestMethod.POST)
	public @ResponseBody Response deleteProduct(@RequestBody ModifyRequest request,
			@RequestHeader("userId") Integer userId) throws SellerServiceExpection {

		request.setUserId(userId);

		Response response = productService.deleteProduct(request);
		return response;
	}

}
