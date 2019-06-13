package com.changepassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.changepassword.model.ChangePasswordModel;

@Repository("ChangePasswordImpl")
public class ChangePasswordDaoImpl implements ChangePasswordDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public Integer changePassword(ChangePasswordModel changePasswordModel) {
		int updateFlagCheck = 0;
		try {
			String query = "update admin_login set admin_password = ? where admin_id = ?";
			updateFlagCheck = jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, changePasswordModel.getNewPassword());
					ps.setInt(2, changePasswordModel.getId());
					return ps;
				}
			});
		} catch (Exception e) {
			updateFlagCheck = 0;
		}
		
		return updateFlagCheck;
	}

}
