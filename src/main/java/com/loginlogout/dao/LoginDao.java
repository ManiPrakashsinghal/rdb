package com.loginlogout.dao;

import java.util.List;

import com.loginlogout.model.LoginModel;

public interface LoginDao {
	List<LoginModel> loginUser(LoginModel loginModel);
}
