package com.project.Request;

public class CartRequest extends Request {

	private Integer id;
	private Integer mainCartId;
	private Integer productId;
	private Integer totalProductQuantity;
	private Integer totalProductPrice;
	private Integer status;

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

}
