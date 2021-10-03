package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
