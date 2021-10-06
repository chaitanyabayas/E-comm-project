package com.project.Dto;

import java.time.LocalDateTime;

import com.project.Model.SubCatagory;

public class SubCatagoryDTO {

	private Integer id;
	private String subCatagoryName;
	private Integer createdBy;
	private LocalDateTime createdDate;
	private Integer updatedBy;
	private LocalDateTime updatedDate;
	private Boolean active;

	public SubCatagoryDTO() {
	}

	public SubCatagoryDTO(SubCatagory subCatagory) {

		this.id = subCatagory.getId();
		this.subCatagoryName = subCatagory.getSubCatagoryName();
		this.createdBy = subCatagory.getCreatedBy();
		this.createdDate = subCatagory.getCreatedDate();
		this.updatedBy = subCatagory.getUpdatedBy();
		this.updatedDate = subCatagory.getUpdatedDate();
		this.active = subCatagory.getActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubCatagoryName() {
		return subCatagoryName;
	}

	public void setSubCatagoryName(String subCatagoryName) {
		this.subCatagoryName = subCatagoryName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
