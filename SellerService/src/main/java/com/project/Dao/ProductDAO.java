package com.project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

	@Query("select product from Product product where product.id = :id and product.active = 1")
	Product findProductById(Integer id);

	@Query("select product from Product product where product.active = 1")
	List<Product> findAllProduct();

}
