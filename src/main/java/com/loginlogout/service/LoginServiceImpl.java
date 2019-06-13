package com.loginlogout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginlogout.dao.LoginDao;
import com.loginlogout.model.LoginModel;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	
	@Override
	public List<LoginModel> loginUser(LoginModel loginModel) {
		return loginDao.loginUser(loginModel);
	}

}
