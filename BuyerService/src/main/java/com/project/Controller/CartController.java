package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.BuyerServiceExpection;
import com.project.Request.CartRequest;
import com.project.Response.CartResponse;
import com.project.Response.Response;
import com.project.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "addToCart", method = RequestMethod.POST, produces = "application/json")
	public Response addToCart(@RequestBody CartRequest request, @RequestHeader(value = "userId") Integer userId)
			throws BuyerServiceExpection {
		request.setUserId(userId);

		Response response = cartService.addToCart(request);
		return response;
	}

	@RequestMapping(value = "getCartData", method = RequestMethod.POST, produces = "application/json")
	public CartResponse getCartData(@RequestBody CartRequest request, @RequestHeader(value = "userId") Integer userId)
			throws BuyerServiceExpection {

		request.setUserId(userId);
		CartResponse response = cartService.getCartData(request);
		return response;
	}

}
