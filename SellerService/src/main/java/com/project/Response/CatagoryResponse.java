package com.project.Response;

import java.util.List;

import com.project.Dto.CatagoryDTO;

public class CatagoryResponse extends Response {

	public List<CatagoryDTO> catagoryDTO;

	public List<CatagoryDTO> getCatagoryDTO() {
		return catagoryDTO;
	}

	public void setCatagoryDTO(List<CatagoryDTO> catagoryDTO) {
		this.catagoryDTO = catagoryDTO;
	}

}
