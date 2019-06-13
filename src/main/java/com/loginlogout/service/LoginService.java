package com.loginlogout.service;

import java.util.List;

import com.loginlogout.model.LoginModel;

public interface LoginService {
	List<LoginModel> loginUser(LoginModel loginModel);
}
