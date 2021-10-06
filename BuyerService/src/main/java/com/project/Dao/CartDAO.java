package com.project.Dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer> {

	@Query("select cart from Cart cart where cart.productId = :productId and cart.createdBy = :userId and cart.active = 1 ORDER BY id DESC")
	Cart findByProductId(Integer productId, Integer integer);

	@Query("select cart from Cart cart where cart.createdBy = :userId and cart.active = 1 ORDER BY id DESC")
	ArrayList<Cart> findAllCartDataByUserId(Integer userId);

	@Query("select cart from Cart cart where cart.id = :id and cart.active = 1")
	Cart findCartById(Integer id);

}
