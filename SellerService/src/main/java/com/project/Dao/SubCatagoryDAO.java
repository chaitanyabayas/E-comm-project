package com.project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.SubCatagory;

public interface SubCatagoryDAO extends JpaRepository<SubCatagory, Integer>, JpaSpecificationExecutor<SubCatagory> {

	SubCatagory findBySubCatagoryName(String subCatagoryName);

	@Query("select subCatagory from SubCatagory subCatagory where subCatagory.id = :id and subCatagory.active = 1")
	SubCatagory findSubCatagoryById(Integer id);

	@Query("select subCatagory from SubCatagory subCatagory where subCatagory.active = 1")
	List<SubCatagory> findAllSubCatagory();

}
