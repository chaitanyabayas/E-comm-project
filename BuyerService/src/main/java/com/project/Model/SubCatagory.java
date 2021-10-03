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
@Table(name = "product_sub_catagory")
public class SubCatagory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "catagory_id")
	private Integer catagoryId;

	@Column(name = "sub_catagory_name")
	private String subCatagoryName;

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
