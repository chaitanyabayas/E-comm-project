package com.project.Response;

import java.util.List;

import com.project.Dto.PageData;

public class PageDataResponse<T> extends Response {

	private PageData<T> page;
	private List<T> data;

	public PageData<T> getPage() {
		return page;
	}

	public void setPage(PageData<T> page) {
		this.page = page;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
