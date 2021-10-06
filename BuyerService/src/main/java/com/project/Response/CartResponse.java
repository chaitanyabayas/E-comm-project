package com.project.Response;

import java.util.List;

import com.project.Dto.CartDTO;

public class CartResponse extends Response {

	public List<CartDTO> cartDTO;

	public List<CartDTO> getCartDTO() {
		return cartDTO;
	}

	public void setCartDTO(List<CartDTO> cartDTO) {
		this.cartDTO = cartDTO;
	}

}
