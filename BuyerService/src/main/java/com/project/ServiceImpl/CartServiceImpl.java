package com.project.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BuyerService.ResponseStatus;
import com.project.Dao.CartDAO;
import com.project.Dto.CartDTO;
import com.project.Exception.BuyerServiceExpection;
import com.project.Model.Cart;
import com.project.Request.CartRequest;
import com.project.Response.CartResponse;
import com.project.Response.Response;
import com.project.Service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;

	@Override
	public Response addToCart(CartRequest request) throws BuyerServiceExpection {
		Response response = new Response();

		if (request.getProductId() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Please select any product.");
		}

		Cart cart = null;

		if (request.getId() != null) {
			cart = cartDAO.findCartById(request.getId());
		}

		if (cart == null) {
			cart = new Cart();
			cart.setProductId(request.getProductId());
			cart.setTotalProductQuantity(request.getTotalProductQuantity());
			cart.setTotalProductPrice(request.getTotalProductPrice());

			cart.setCreatedBy(request.getUserId());
			cart.setCreatedDate(LocalDateTime.now());
			cart.setUpdatedBy(request.getUserId());
			cart.setUpdatedDate(LocalDateTime.now());
			cart.setActive(true);

		} else {
			cart.setProductId(request.getProductId());
			cart.setTotalProductQuantity(request.getTotalProductQuantity());
			cart.setTotalProductPrice(request.getTotalProductPrice());

			cart.setUpdatedBy(request.getUserId());
			cart.setUpdatedDate(LocalDateTime.now());
			cart.setActive(true);
		}

		cartDAO.save(cart);

		response.setStatus(ResponseStatus.OK);
		if (request.getId() == null) {
			response.setMessage("Added to cart");
		} else {
			response.setMessage("Updated to cart");
		}
		return response;
	}

	@Override
	public CartResponse getCartData(CartRequest request) throws BuyerServiceExpection {
		CartResponse response = new CartResponse();

		List<Cart> carts = cartDAO.findAllCartDataByUserId(request.getUserId());
		List<CartDTO> cartDTO = new ArrayList<CartDTO>();

		for (Cart cart : carts) {
			CartDTO dto = new CartDTO(cart);
			cartDTO.add(dto);
		}

		response.setStatus(ResponseStatus.OK);
		response.setMessage("Cart Fetched!");
		response.setCartDTO(cartDTO);
		return response;
	}

}
