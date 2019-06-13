package com.client.dao;

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

import com.client.model.ClientModel;

@Repository("clientDetailsDaoImpl")
public class ClientDetailsDaoImpl implements ClientDetailsDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public Integer insertClientBasicDetails(ClientModel clientModel) {
		String query="insert into client_details(firstName, middleName, lastName, fatherHusName, executiveName, pLine1, pLine2, pCity, pDistrict, pState, pPinCode, lLine1, lLine2, lCity, lDistrict, lState, lPinCode, registrationDate, clientType) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, clientModel.getFirstName());
				ps.setString(2, clientModel.getMiddleName());
				ps.setString(3, clientModel.getLastName());
				ps.setString(4, clientModel.getFatherHusName());
				ps.setString(5, clientModel.getExecutiveName());
				ps.setString(6, clientModel.getpLine1());
				ps.setString(7, clientModel.getpLine2());
				ps.setString(8, clientModel.getpCity());
				ps.setString(9, clientModel.getpDistrict());
				ps.setString(10, clientModel.getpState());
				ps.setString(11, clientModel.getpPinCode());
				ps.setString(12, clientModel.getlLine1());
				ps.setString(13, clientModel.getlLine2());
				ps.setString(14, clientModel.getlCity());
				ps.setString(15, clientModel.getlDistrict());
				ps.setString(16, clientModel.getlState());
				ps.setString(17, clientModel.getlPinCode());
				ps.setString(18, clientModel.getRegistrationDate());
				ps.setInt(19, clientModel.getClientType());
				return ps;
			}
		},keyHolder);
		 return keyHolder.getKey().intValue();
	}

	@Override
	public Integer insertClientFinanceDetails(ClientModel clientModel) {
		String query = "insert into client_finance_details(client_id, firstReferenceName, firstReferenceMobile, secondReferenceName, secondReferenceMobile, loanAmount, installment, paymentDate, financeDescription)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, clientModel.getClient_id());
				ps.setString(2, clientModel.getFirstReferenceName());
				ps.setString(3, clientModel.getFirstReferenceMobile());
				ps.setString(4, clientModel.getSecondReferenceName());
				ps.setString(5, clientModel.getSecondReferenceMobile());
				ps.setString(6, clientModel.getLoanAmount());
				ps.setString(7, clientModel.getFinanceInstallment());
				ps.setString(8, clientModel.getFinancePaymentDate());
				ps.setString(9, clientModel.getFinanceDescription());
				return ps;
			}
		});
	}


	@Override
	public Integer insertClientRealEstateDetails(ClientModel clientModel) {
		String query = "insert into client_real_estate_details(client_id, nomineeName, 	nomineeRelation, schemeName, "
				+ "paymentType, installmentAmount, firstInstallmentDate, lastInstallmentDate, totalArea,"
				+ "basicRateOfPlot, basicRateOfShop, totalPayment, realEstateDescription, plotStatus)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, clientModel.getClient_id());
				ps.setString(2, clientModel.getNomineeName());
				ps.setString(3, clientModel.getNomineeRelation());
				ps.setString(4, clientModel.getSchemeId());
				ps.setString(5, clientModel.getPaymentType());
				ps.setString(6, clientModel.getFinanceInstallment());
				ps.setString(7, clientModel.getFirstInstallmentDate());
				ps.setString(8, clientModel.getLastInstallmentDate());
				ps.setString(9, clientModel.getTotalArea());
				ps.setString(10, clientModel.getBasicRateOfPlot());
				ps.setString(11, clientModel.getBasicRateOfShop());
				ps.setString(12, clientModel.getTotalPayment());
				ps.setString(13, clientModel.getRealEstateDescription());
				ps.setString(14, clientModel.getPlotStatus());
				return ps;
			}
		});
	}


	@Override
	public Integer updateClientBasicDetails(ClientModel clientModel) {
		String query = "update client_details set firstName = ?, middleName = ?, lastName = ?, fatherHusName = ?,"
				+ "executiveName = ?, pLine1 = ?, pLine2 = ?, pCity = ?, pDistrict = ?, pState = ?, pPinCode = ?,"
				+ "lLine1 = ?, lLine2 = ?, lCity = ?, lDistrict = ?, lState = ?, lPinCode = ?, registrationDate = ?,"
				+ "clientType = ? where client_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, clientModel.getFirstName());
				ps.setString(2, clientModel.getMiddleName());
				ps.setString(3, clientModel.getLastName());
				ps.setString(4, clientModel.getFatherHusName());
				ps.setString(5, clientModel.getExecutiveName());
				ps.setString(6, clientModel.getpLine1());
				ps.setString(7, clientModel.getpLine2());
				ps.setString(8, clientModel.getpCity());
				ps.setString(9, clientModel.getpDistrict());
				ps.setString(10, clientModel.getpState());
				ps.setString(11, clientModel.getpPinCode());
				ps.setString(12, clientModel.getlLine1());
				ps.setString(13, clientModel.getlLine2());
				ps.setString(14, clientModel.getlCity());
				ps.setString(15, clientModel.getlDistrict());
				ps.setString(16, clientModel.getlState());
				ps.setString(17, clientModel.getlPinCode());
				ps.setString(18, clientModel.getRegistrationDate());
				ps.setInt(19, clientModel.getClientType());
				ps.setInt(20, clientModel.getClient_id());
				return ps;
			}
		});
	}


	@Override
	public Integer updateClientFinanceDetails(ClientModel clientModel) {
		String query = "update client_finance_details set firstReferenceName = ?, firstReferenceMobile = ?,"
				+ "secondReferenceName = ?, secondReferenceMobile = ?, loanAmount = ?, installment = ?,"
				+ "paymentDate = ?, financeDescription = ? where client_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, clientModel.getFirstReferenceName());
				ps.setString(2, clientModel.getFirstReferenceMobile());
				ps.setString(3, clientModel.getSecondReferenceName());
				ps.setString(4, clientModel.getSecondReferenceMobile());
				ps.setString(5, clientModel.getLoanAmount());
				ps.setString(6, clientModel.getFinanceInstallment());
				ps.setString(7, clientModel.getFinancePaymentDate());
				ps.setString(8, clientModel.getFinanceDescription());
				ps.setInt(9, clientModel.getClient_id());
				return ps;
			}
		});
	}


	@Override
	public Integer updateClientRealEstateDetails(ClientModel clientModel) {
		String query = "update client_real_estate_details set nomineeName = ?, nomineeRelation = ?,"
				+ "schemeName = ?, paymentType = ?, installmentAmount = ?, firstInstallmentDate = ?,"
				+ "lastInstallmentDate = ?, totalArea = ?, basicRateOfPlot = ?, basicRateOfShop = ?,"
				+ "totalPayment = ?, realEstateDescription = ?, plotStatus = ? where client_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, clientModel.getNomineeName());
				ps.setString(2, clientModel.getNomineeRelation());
				ps.setString(3, clientModel.getSchemeId());
				ps.setString(4, clientModel.getPaymentType());
				ps.setString(5, clientModel.getRealEstateInstallment());
				ps.setString(6, clientModel.getFirstInstallmentDate());
				ps.setString(7, clientModel.getLastInstallmentDate());
				ps.setString(8, clientModel.getTotalArea());
				ps.setString(9, clientModel.getBasicRateOfPlot());
				ps.setString(10, clientModel.getBasicRateOfShop());
				ps.setString(11, clientModel.getTotalPayment());
				ps.setString(12, clientModel.getRealEstateDescription());
				ps.setString(13, clientModel.getPlotStatus());
				ps.setInt(14, clientModel.getClient_id());
				return ps;
			}
		});
	}


	@Override
	public Integer updatePlotDetails(ClientModel clientModel, String plotNumber, String plotType) {
		String query = "update plot_shop_details set client_id = ?, plotStatus = ?"
				+ "where schemeId = ? and plot_number = ? and plotType = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, clientModel.getClient_id());
				ps.setString(2, clientModel.getPlotStatus());
				ps.setString(3, clientModel.getSchemeId());
				ps.setString(4, plotNumber);
				ps.setString(5, plotType);
				return ps;
			}
		});
	}


	@Override
	public List<ClientModel> getFinanceClientDetails(JSONObject jsonObject) {
		String fromDate = (String) jsonObject.get("fromDate");
		String toDate = (String) jsonObject.get("toDate");
		
		String query = "";
		if(fromDate != null && toDate != null){
			query = "select * from client_details inner join client_finance_details "
					+ "on client_details.client_id = client_finance_details.client_id"
					+ "where registrationDate between '"+fromDate+"' and '"+toDate+"'";
		}else{
			query = "select * from client_details inner join client_finance_details "
					+ "on client_details.client_id = client_finance_details.client_id";
		}
		query = "select * from client_details inner join client_finance_details "
				+ "on client_details.client_id = client_finance_details.client_id";
		
		return jdbcTemplate.query(query, new RowMapper<ClientModel>(){

			@Override
			public ClientModel mapRow(ResultSet rs, int arg1) throws SQLException {
				ClientModel cm = new ClientModel();
				cm.setClient_id(rs.getInt("client_id"));
				cm.setFirstName(rs.getString("firstName"));
				cm.setMiddleName(rs.getString("middleName"));
				cm.setLastName(rs.getString("lastName"));
				cm.setFatherHusName(rs.getString("fatherHusName"));
				cm.setExecutiveName(rs.getString("executiveName"));
				cm.setpLine1(rs.getString("pLine1"));
				cm.setpLine2(rs.getString("pLine2"));
				cm.setpCity(rs.getString("pCity"));
				cm.setpDistrict(rs.getString("pDistrict"));
				cm.setpState(rs.getString("pState"));
				cm.setpPinCode(rs.getString("pPinCode"));
				cm.setlLine1(rs.getString("lLine1"));
				cm.setlLine2(rs.getString("lLine2"));
				cm.setlCity(rs.getString("lCity"));
				cm.setlDistrict(rs.getString("lDistrict"));
				cm.setlState(rs.getString("lState"));
				cm.setlPinCode(rs.getString("lPinCode"));
				cm.setRegistrationDate(rs.getString("registrationDate"));
				cm.setClientType(rs.getInt("clientType"));
				cm.setClient_fin_det_id(rs.getString("client_fin_det_id"));
				cm.setFirstReferenceName(rs.getString("firstReferenceName"));
				cm.setFirstReferenceMobile(rs.getString("firstReferenceMobile"));
				cm.setSecondReferenceName(rs.getString("secondReferenceName"));
				cm.setSecondReferenceMobile(rs.getString("secondReferenceMobile"));
				cm.setLoanAmount(rs.getString("loanAmount"));
				cm.setFinanceInstallment(rs.getString("installment"));
				cm.setFinancePaymentDate(rs.getString("paymentDate"));
				cm.setFinanceDescription(rs.getString("financeDescription"));
				return cm;
			}
			
		});
	}


	@Override
	public List<ClientModel> getRealEstateClientDetails(JSONObject jsonObject) {
		String fromDate = (String) jsonObject.get("fromDate");
		String toDate = (String) jsonObject.get("toDate");
		
		String query = "";
		if(fromDate != null && toDate != null){
			query = "select * from client_details inner join client_real_estate_details on "
					+ "client_details.client_id = client_real_estate_details.client_id "
					+ "where client_details.registrationDate between '"+fromDate+"' and '"+toDate+"'";
		}else{
			query = "select * from client_details inner join client_real_estate_details on "
					+ "client_details.client_id = client_real_estate_details.client_id";
		}
		
		return jdbcTemplate.query(query, new RowMapper<ClientModel>() {

			@Override
			public ClientModel mapRow(ResultSet rs, int arg1) throws SQLException {
				ClientModel cm = new ClientModel();
				cm.setClient_id(rs.getInt("client_id"));
				cm.setFirstName(rs.getString("firstName"));
				cm.setMiddleName(rs.getString("middleName"));
				cm.setLastName(rs.getString("lastName"));
				cm.setFatherHusName(rs.getString("fatherHusName"));
				cm.setExecutiveName(rs.getString("executiveName"));
				cm.setpLine1(rs.getString("pLine1"));
				cm.setpLine2(rs.getString("pLine2"));
				cm.setpCity(rs.getString("pCity"));
				cm.setpDistrict(rs.getString("pDistrict"));
				cm.setpState(rs.getString("pState"));
				cm.setpPinCode(rs.getString("pPinCode"));
				cm.setlLine1(rs.getString("lLine1"));
				cm.setlLine2(rs.getString("lLine2"));
				cm.setlCity(rs.getString("lCity"));
				cm.setlDistrict(rs.getString("lDistrict"));
				cm.setlState(rs.getString("lState"));
				cm.setlPinCode(rs.getString("lPinCode"));
				cm.setRegistrationDate(rs.getString("registrationDate"));
				cm.setClientType(rs.getInt("clientType"));
				cm.setClient_re_es_id(rs.getString("client_re_es_id"));
				cm.setNomineeName(rs.getString("nomineeName"));
				cm.setNomineeRelation(rs.getString("nomineeRelation"));
				cm.setSchemeId(rs.getString("schemeName"));
				cm.setPaymentType(rs.getString("paymentType"));
				cm.setRealEstateInstallment(rs.getString("installmentAmount"));
				cm.setFirstInstallmentDate(rs.getString("firstInstallmentDate"));
				cm.setLastInstallmentDate(rs.getString("lastInstallmentDate"));
				cm.setTotalArea(rs.getString("totalArea"));
				cm.setBasicRateOfPlot(rs.getString("basicRateOfPlot"));
				cm.setBasicRateOfShop(rs.getString("basicRateOfShop"));
				cm.setTotalPayment(rs.getString("totalPayment"));
				cm.setRealEstateDescription(rs.getString("realEstateDescription"));
				cm.setPlotStatus(rs.getString("plotStatus"));
				return cm;
			}
		});
	}


	@Override
	public List<ClientModel> getPlotDetails(ClientModel clientModel) {
		String query = "select * from plot_shop_details "
				+ "where schemeId = ? and client_id = ?";
		String schemeId = clientModel.getSchemeId();
		int clientId = clientModel.getClient_id();

		return jdbcTemplate.query(query, new Object[]{schemeId, clientId}, new RowMapper<ClientModel>(){

			@Override
			public ClientModel mapRow(ResultSet rs, int arg1) throws SQLException {
				ClientModel cm = new ClientModel();
				cm.setPlot_id(rs.getString("plot_id"));
				cm.setPlotNumber(rs.getString("plot_number"));
				cm.setPlotType(rs.getString("plotType"));
				cm.setPlotStatus(rs.getString("plotStatus"));
				return cm;
			}
			
		});
	}

}
