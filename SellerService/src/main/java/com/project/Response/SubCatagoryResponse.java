package com.project.Response;

import java.util.List;

import com.project.Dto.SubCatagoryDTO;

public class SubCatagoryResponse extends Response {

	public List<SubCatagoryDTO> subCatagoryDTO;

	public List<SubCatagoryDTO> getSubCatagoryDTO() {
		return subCatagoryDTO;
	}

	public void setSubCatagoryDTO(List<SubCatagoryDTO> subCatagoryDTO) {
		this.subCatagoryDTO = subCatagoryDTO;
	}

}
