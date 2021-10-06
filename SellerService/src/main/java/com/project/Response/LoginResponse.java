package com.project.Response;

import com.project.Dto.UserDTO;

public class LoginResponse extends Response {

	public UserDTO userDTO;

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
