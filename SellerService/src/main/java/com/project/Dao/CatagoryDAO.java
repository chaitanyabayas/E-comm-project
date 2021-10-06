package com.project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.Catagory;

public interface CatagoryDAO extends JpaRepository<Catagory, Integer>, JpaSpecificationExecutor<Catagory> {

	Catagory findByCatagoryName(String catagoryName);

	@Query("select catagory from Catagory catagory where catagory.id = :id and catagory.active = 1")
	Catagory findCatagoryById(Integer id);

	@Query("select catagory from Catagory catagory where catagory.active = 1")
	List<Catagory> findAllCatagory();

}
