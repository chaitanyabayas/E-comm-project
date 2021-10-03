package com.project.Dto;

import java.time.LocalDateTime;

import com.project.Model.UserAddress;

public class UserAddressDTO {

	private Integer id;
	private Integer userId;
	private String buildingName;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pinCode;
	private Integer createdBy;
	private LocalDateTime createdDate;
	private Integer updatedBy;
	private LocalDateTime updatedDate;
	private Boolean active;

	public UserAddressDTO() {
	}

	public UserAddressDTO(UserAddress userAddress) {

		this.id = userAddress.getId();
		this.userId = userAddress.getUserId();
		this.buildingName = userAddress.getBuildingName();
		this.area = userAddress.getArea();
		this.city = userAddress.getCity();
		this.state = userAddress.getState();
		this.country = userAddress.getCountry();
		this.pinCode = userAddress.getPinCode();
		this.createdBy = userAddress.getCreatedBy();
		this.createdDate = userAddress.getCreatedDate();
		this.updatedBy = userAddress.getUpdatedBy();
		this.updatedDate = userAddress.getUpdatedDate();
		this.active = userAddress.getActive();
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

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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
