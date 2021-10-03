package com.project.Dto;

import java.time.LocalDateTime;

import com.project.Model.Cart;

public class CartDTO {

	private Integer id;
	private Integer mainCartId;
	private Integer productId;
	private Integer totalProductQuantity;
	private Integer totalProductPrice;
	private Integer status;
	private Integer createdBy;
	private LocalDateTime createdDate;
	private Integer updatedBy;
	private LocalDateTime updatedDate;
	private Boolean active;

	public CartDTO() {
	}

	public CartDTO(Cart cart) {

		this.id = cart.getId();
		this.mainCartId = cart.getMainCartId();
		this.productId = cart.getProductId();
		this.totalProductQuantity = cart.getTotalProductQuantity();
		this.totalProductPrice = cart.getTotalProductPrice();
		this.status = cart.getStatus();
		this.createdBy = cart.getCreatedBy();
		this.createdDate = cart.getCreatedDate();
		this.updatedBy = cart.getUpdatedBy();
		this.updatedDate = cart.getUpdatedDate();
		this.active = cart.getActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMainCartId() {
		return mainCartId;
	}

	public void setMainCartId(Integer mainCartId) {
		this.mainCartId = mainCartId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getTotalProductQuantity() {
		return totalProductQuantity;
	}

	public void setTotalProductQuantity(Integer totalProductQuantity) {
		this.totalProductQuantity = totalProductQuantity;
	}

	public Integer getTotalProductPrice() {
		return totalProductPrice;
	}

	public void setTotalProductPrice(Integer totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
