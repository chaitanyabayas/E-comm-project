package com.project.Request;

public class SubCatagoryRequest {

	private Integer id;
	private Integer catagoryId;
	private String subCatagoryName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}

	public String getSubCatagoryName() {
		return subCatagoryName;
	}

	public void setSubCatagoryName(String subCatagoryName) {
		this.subCatagoryName = subCatagoryName;
	}

}
