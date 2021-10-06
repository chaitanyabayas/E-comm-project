package com.project.Service;

import com.project.Exception.SellerServiceExpection;
import com.project.Request.LoginRequest;
import com.project.Request.UserRequest;
import com.project.Response.LoginResponse;
import com.project.Response.Response;

public interface UserService {

	Response userRegister(UserRequest request) throws SellerServiceExpection;

	LoginResponse userLogin(LoginRequest request) throws SellerServiceExpection;

}
