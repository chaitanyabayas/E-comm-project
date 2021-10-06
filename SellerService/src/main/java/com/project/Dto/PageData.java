package com.project.Dto;

import java.util.List;

public class PageData<T> {

	private Integer pageNumber;
	private Integer size;
	private Integer totalElements;
	private Integer totalPages;
	private Boolean sort;
	private List<SortProperty> prop;
	private T filter;

	public PageData() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Boolean getSort() {
		return sort;
	}

	public void setSort(Boolean sort) {
		this.sort = sort;
	}

	public List<SortProperty> getProp() {
		return prop;
	}

	public void setProp(List<SortProperty> prop) {
		this.prop = prop;
	}

	public T getFilter() {
		return filter;
	}

	public void setFilter(T filter) {
		this.filter = filter;
	}

}
