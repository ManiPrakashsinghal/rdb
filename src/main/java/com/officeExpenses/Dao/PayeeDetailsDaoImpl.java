package com.officeExpenses.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.officeExpenses.model.PayeeDetailsModel;
@Repository("payeeDetailsDaoImpl")
public class PayeeDetailsDaoImpl implements PayeeDetailsDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void setTemplate(JdbcTemplate jdbcTemplate) {    
	    this.jdbcTemplate = jdbcTemplate;    
	} 
	public List<PayeeDetailsModel> getAllPayeeDetailsDao() {
		List<PayeeDetailsModel> list = new ArrayList<PayeeDetailsModel>();
		System.out.println("dao ss");
		list = jdbcTemplate.query("select * from payeenames", new RowMapper<PayeeDetailsModel>(){
		
			public PayeeDetailsModel mapRow(ResultSet rs, int arg1) throws SQLException {
				PayeeDetailsModel payeeDetailsModel = new PayeeDetailsModel();
				
				payeeDetailsModel.setId(rs.getInt("payeeNamesId"));
				payeeDetailsModel.setPayeeName(rs.getString("payeeName"));
				payeeDetailsModel.setOtherDetails(rs.getString("otherDetails"));
				return payeeDetailsModel;
			}});
		return list;
	}
	@Override
	public Integer insertPayeeDetails(PayeeDetailsModel payeeDetailsModel) {
		String query = "insert into payeenames(payeeName,otherDetails)values(?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, payeeDetailsModel.getPayeeName());
				ps.setString(2, payeeDetailsModel.getOtherDetails());
				return ps;
			}
		},keyHolder);
		return keyHolder.getKey().intValue();
	}
	@Override
	public Integer updatePayeeDetails(PayeeDetailsModel payeeDetailsModel) {
		String updateQuery = "update payeenames set payeeName = ?, otherDetails = ? where payeeNamesId = ?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int updateFlagCheck = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(updateQuery);
				ps.setString(1, payeeDetailsModel.getPayeeName());
				ps.setString(2, payeeDetailsModel.getOtherDetails());
				ps.setLong(3, payeeDetailsModel.getId());
				return ps;
			}
		},keyHolder);
		return updateFlagCheck;
	}

}
