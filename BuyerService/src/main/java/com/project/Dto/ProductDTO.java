package com.project.Dto;

import java.time.LocalDateTime;

import com.project.Model.Product;

public class ProductDTO {

	private Integer id;
	private String subCatagoryId;
	private String productName;
	private String productPrice;
	private String productQuantity;
	private String productImage;
	private String prodectManufacturer;
	private String prodectModel;
	private String manufacturingDate;
	private String expiryDate;
	private String manufacturedAt;
	private Integer createdBy;
	private LocalDateTime createdDate;
	private Integer updatedBy;
	private LocalDateTime updatedDate;
	private Boolean active;

	public ProductDTO() {
	}

	public ProductDTO(Product product) {

		this.id = product.getId();
		this.subCatagoryId = product.getSubCatagoryId();
		this.productName = product.getProductName();
		this.productPrice = product.getProductPrice();
		this.productQuantity = product.getProductQuantity();
		this.productImage = product.getProductImage();
		this.prodectManufacturer = product.getProdectManufacturer();
		this.prodectModel = product.getProdectModel();
		this.manufacturingDate = product.getManufacturingDate();
		this.expiryDate = product.getExpiryDate();
		this.manufacturedAt = product.getManufacturedAt();
		this.createdBy = product.getCreatedBy();
		this.createdDate = product.getCreatedDate();
		this.updatedBy = product.getUpdatedBy();
		this.updatedDate = product.getUpdatedDate();
		this.active = product.getActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubCatagoryId() {
		return subCatagoryId;
	}

	public void setSubCatagoryId(String subCatagoryId) {
		this.subCatagoryId = subCatagoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProdectManufacturer() {
		return prodectManufacturer;
	}

	public void setProdectManufacturer(String prodectManufacturer) {
		this.prodectManufacturer = prodectManufacturer;
	}

	public String getProdectModel() {
		return prodectModel;
	}

	public void setProdectModel(String prodectModel) {
		this.prodectModel = prodectModel;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getManufacturedAt() {
		return manufacturedAt;
	}

	public void setManufacturedAt(String manufacturedAt) {
		this.manufacturedAt = manufacturedAt;
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
