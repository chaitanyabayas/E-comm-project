package com.project.Dto;

import java.time.LocalDateTime;

import com.project.Model.Catagory;

public class CatagoryDTO {

	private Integer id;
	private Integer catagoryName;
	private Integer createdBy;
	private LocalDateTime createdDate;
	private Integer updatedBy;
	private LocalDateTime updatedDate;
	private Boolean active;

	public CatagoryDTO() {
	}

	public CatagoryDTO(Catagory catagory) {

		this.id = catagory.getId();
		this.catagoryName = catagory.getCatagoryName();
		this.createdBy = catagory.getCreatedBy();
		this.createdDate = catagory.getCreatedDate();
		this.updatedBy = catagory.getUpdatedBy();
		this.updatedDate = catagory.getUpdatedDate();
		this.active = catagory.getActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(Integer catagoryName) {
		this.catagoryName = catagoryName;
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
