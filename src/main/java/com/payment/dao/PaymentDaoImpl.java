package com.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.payment.model.PaymentModel;

@Repository
public class PaymentDaoImpl implements PaymentDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Integer insertPaymentDetails(PaymentModel paymentModel) {
		String query = "insert into payment_details(schemeId, mobileNumber, paymentType, amount, paymentDate,"
				+ "description, paymentSuccess) values(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, paymentModel.getSchemeId());
				ps.setString(2, paymentModel.getMobileNumber());
				ps.setString(3, paymentModel.getPaymentType());
				ps.setInt(4, paymentModel.getAmount());
				ps.setString(5, paymentModel.getPaymentDate());
				ps.setString(6, paymentModel.getDescription());
				ps.setString(7, paymentModel.getPaymentSuccess());
				return ps;
			}
		});
	}

	@Override
	public Integer updatePaymentDetails(PaymentModel paymentModel) {
		String query = "update payment_details set schemeId = ?, mobileNumber = ?, paymentType = ?, amount = ?,"
				+ "paymentDate = ?, description = ?, paymentSuccess = ? where paymentId = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, paymentModel.getSchemeId());
				ps.setString(2, paymentModel.getMobileNumber());
				ps.setString(3, paymentModel.getPaymentType());
				ps.setInt(4, paymentModel.getAmount());
				ps.setString(5, paymentModel.getPaymentDate());
				ps.setString(6, paymentModel.getDescription());
				ps.setString(7, paymentModel.getPaymentSuccess());
				ps.setInt(8, paymentModel.getPaymentid());
				return ps;
			}
		});
	}

	@Override
	public List<PaymentModel> getPaymentDetails(JSONObject jsonObject) {
		String fromDate = (String) jsonObject.get("fromDate");
		String toDate = (String) jsonObject.get("toDate");
		String mobileNumber = (String) jsonObject.get("mobileNumber");
		System.out.println("mobile number "+mobileNumber);
		String query = "";
		if(mobileNumber == null || fromDate != null || toDate != null){
			mobileNumber = "";
			fromDate     = "";
			toDate       = "";
		}
		if(fromDate != "" && toDate != ""){
			query = "select * from payment_details where mobileNumber like '%"+mobileNumber+"%' and paymentDate between '"+fromDate+"' and '"+toDate+"'";
		}else{
			query = "select * from payment_details where mobileNumber like '%"+mobileNumber+"%'";
		}
		
		return jdbcTemplate.query(query, new RowMapper<PaymentModel>(){

			@Override
			public PaymentModel mapRow(ResultSet rs, int arg1) throws SQLException {
				PaymentModel ps = new PaymentModel();
				ps.setPaymentid(rs.getInt("paymentId"));
				ps.setSchemeId(rs.getString("schemeId"));
				ps.setMobileNumber(rs.getString("mobileNumber"));
				ps.setPaymentType(rs.getString("paymentType"));
				ps.setAmount(rs.getInt("amount"));
				ps.setPaymentDate(rs.getString("paymentDate"));
				ps.setDescription(rs.getString("description"));
				ps.setPaymentSuccess(rs.getString("paymentSuccess"));
				return ps;
			}
			
		});
	}

}
