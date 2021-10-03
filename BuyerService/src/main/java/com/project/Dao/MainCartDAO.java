package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.MainCart;

public interface MainCartDAO extends JpaRepository<MainCart, Integer> {

	@Query("select maincart from MainCart maincart where maincart.userId = :id")
	MainCart findMainCartByUserId(Integer id);

}
