package com.project.Response;

import java.util.List;

import com.project.Dto.ProductDTO;

public class ProductResponse extends Response {

	public List<ProductDTO> productDTO;

	public List<ProductDTO> getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(List<ProductDTO> productDTO) {
		this.productDTO = productDTO;
	}

}
