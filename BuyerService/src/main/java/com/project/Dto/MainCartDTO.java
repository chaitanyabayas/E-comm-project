package com.project.Dto;

import java.time.LocalDateTime;

import com.project.Model.MainCart;

public class MainCartDTO {

	private Integer id;
	private Integer userId;
	private Integer createdBy;
	private LocalDateTime createdDate;
	private Integer updatedBy;
	private LocalDateTime updatedDate;
	private Boolean active;

	public MainCartDTO() {
	}

	public MainCartDTO(MainCart mainCart) {

		this.id = mainCart.getId();
		this.userId = mainCart.getUserId();
		this.createdBy = mainCart.getCreatedBy();
		this.createdDate = mainCart.getCreatedDate();
		this.updatedBy = mainCart.getUpdatedBy();
		this.updatedDate = mainCart.getUpdatedDate();
		this.active = mainCart.getActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
