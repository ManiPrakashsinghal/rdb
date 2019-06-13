package com.changepassword.dao;

import org.json.simple.JSONObject;

import com.changepassword.model.ChangePasswordModel;

public interface ChangePasswordDao {
	Integer changePassword(ChangePasswordModel changePasswordModel);
}
