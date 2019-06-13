package com.loginlogout.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.loginlogout.model.LoginModel;

@Repository("loginDaoImpl")
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<LoginModel> loginUser(LoginModel loginModel) {
		String query = "select * from admin_login where admin_name = ? and admin_password = ?";
		List<LoginModel> list = null;
		 jdbcTemplate.query(query, new Object[]{loginModel.getUserName(),loginModel.getPassword()}, new RowMapper<LoginModel>(){

			@Override
			public LoginModel mapRow(ResultSet rs, int arg1) throws SQLException {
				LoginModel lm = new LoginModel();
				loginModel.setUserName(rs.getString("admin_name"));
				loginModel.setPassword(rs.getString("admin_password"));
				return lm;
			}
			 
		 });
		return list;
	}

}
