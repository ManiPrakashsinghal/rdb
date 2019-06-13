package com.officeExpenses.Dao;

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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.officeExpenses.model.OfficeExpensesModel;
@Repository("officeExpensesDaoImpl")
public class OfficeExpensesDaoImpl implements OfficeExpensesDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setTemplate(JdbcTemplate jdbcTemplate) {    
	    this.jdbcTemplate = jdbcTemplate;    
	} 
	
	@Override
	public List<OfficeExpensesModel> getAllOfficeExpensesDetails(JSONObject jsonObject) {
		List<OfficeExpensesModel> list = null;
		String payeeNameId = (String) jsonObject.get("payeeNameId");
		String fromDate    = (String) jsonObject.get("fromDate");
		String toDate    = (String) jsonObject.get("toDate");
		
		String query = "";
		if(payeeNameId == null || fromDate == null || toDate == null){
			payeeNameId = "";
			fromDate    = "";
			toDate      = "";
		}
		
		if(fromDate != "" && toDate != ""){
			query = "select * from officeexpensesdetails inner join payeenames on officeexpensesdetails.payeeNameId = payeenames.payeeNamesId where officeexpensesdetails.payeeNameId like '%"+payeeNameId+"%' and officeexpensesdetails.oed_date between '"+fromDate+"' and '"+toDate+"'";
		}else{
			query = "select * from officeexpensesdetails inner join payeenames on officeexpensesdetails.payeeNameId = payeenames.payeeNamesId where payeeNameId like '%"+payeeNameId+"%'";
		}
		
		System.out.println(payeeNameId+" id");
		list = jdbcTemplate.query(query, new RowMapper<OfficeExpensesModel>(){

			@Override
			public OfficeExpensesModel mapRow(ResultSet rs, int arg1) throws SQLException {
				OfficeExpensesModel oeModel = new OfficeExpensesModel();
				oeModel.setAmount(rs.getInt("amount"));
				oeModel.setDiscription(rs.getString("discription"));
				oeModel.setInOutExpenses(rs.getString("inOutExpenses"));
				oeModel.setOedDate(rs.getString("oed_date"));
				oeModel.setOedId(rs.getInt("oed_id"));
				oeModel.setPayeeName(rs.getString("payeeName"));
				oeModel.setPayeeNameId(rs.getInt("payeeNameId"));
				return oeModel;
			}
			
		});
		return list;
	}

	@Override
	public Integer insertOfficeExpensesDetails(OfficeExpensesModel officeExpensesModel) {
		String query = "insert into officeexpensesdetails(payeeNameId,amount,oed_date,discription,InOutExpenses)values(?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setLong(1, officeExpensesModel.getPayeeNameId());
				ps.setLong(2, officeExpensesModel.getAmount());
				ps.setString(3, officeExpensesModel.getOedDate());
				ps.setString(4, officeExpensesModel.getDiscription());
				ps.setString(5, officeExpensesModel.getInOutExpenses());
				return ps;
			}
		},keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer updateOfficeExpensesDetails(OfficeExpensesModel officeExpensesModel) {
		String query = "update officeexpensesdetails set amount=?, oed_date=?, discription=?, InOutExpenses=? where oed_id = ?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int updateFlagCheck = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setLong(1, officeExpensesModel.getAmount());
				ps.setString(2, officeExpensesModel.getOedDate());
				ps.setString(3, officeExpensesModel.getDiscription());
				ps.setString(4, officeExpensesModel.getInOutExpenses());
				ps.setLong(5, officeExpensesModel.getOedId());
				return ps;
			}
		},keyHolder);
		return updateFlagCheck;
	}

}
