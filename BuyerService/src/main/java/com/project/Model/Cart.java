package com.project.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "main_cart_id")
	private Integer mainCartId;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "total_product_quantity")
	private Integer totalProductQuantity;

	@Column(name = "total_product_price")
	private Integer totalProductPrice;

	@Column(name = "status")
	private Integer status;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_date", columnDefinition = "datetime not null default current_timestamp")
	private LocalDateTime createdDate;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_date", columnDefinition = "datetime not null default current_timestamp")
	private LocalDateTime updatedDate;

	@Column(name = "active", columnDefinition = "BIT default true")
	private Boolean active;

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
