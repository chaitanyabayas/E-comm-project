package com.project.Service;

import com.project.Exception.BuyerServiceExpection;
import com.project.Request.LoginRequest;
import com.project.Request.UserRequest;
import com.project.Response.LoginResponse;
import com.project.Response.Response;

public interface UserService {

	Response userRegister(UserRequest request) throws BuyerServiceExpection;

	LoginResponse userLogin(LoginRequest request) throws BuyerServiceExpection;

}
