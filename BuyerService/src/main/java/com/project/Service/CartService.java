package com.project.Service;

import com.project.Exception.BuyerServiceExpection;
import com.project.Request.CartRequest;
import com.project.Response.CartResponse;
import com.project.Response.Response;

public interface CartService {

	CartResponse getCartData(CartRequest request) throws BuyerServiceExpection;

	Response addToCart(CartRequest request) throws BuyerServiceExpection;

}
