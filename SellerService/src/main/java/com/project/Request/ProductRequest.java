package com.project.Request;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest extends Request {

	private Integer id;
	private Integer sellerId;
	private Integer catagoryId;
	private Integer subCatagoryId;
	private String productName;
	private String productDescription;
	private String productPrice;
	private String productQuantity;
	private MultipartFile productImage;
	private String prodectManufacturer;
	private String prodectModel;
	private String manufacturingDate;
	private String expiryDate;
	private String manufacturedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}

	public Integer getSubCatagoryId() {
		return subCatagoryId;
	}

	public void setSubCatagoryId(Integer subCatagoryId) {
		this.subCatagoryId = subCatagoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
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

}
