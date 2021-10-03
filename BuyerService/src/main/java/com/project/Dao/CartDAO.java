package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Model.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer> {

}
