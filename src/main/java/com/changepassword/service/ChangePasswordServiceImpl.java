package com.changepassword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changepassword.dao.ChangePasswordDao;
import com.changepassword.model.ChangePasswordModel;

@Service("changePasswordServiceImpl")
public class ChangePasswordServiceImpl implements ChangePasswordService{

	@Autowired
	ChangePasswordDao changePasswordDao;
	
	@Override
	public Integer changePassword(ChangePasswordModel changePasswordModel) {
		return changePasswordDao.changePassword(changePasswordModel);
	}

}
