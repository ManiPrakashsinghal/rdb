package com.plotScheme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.plotScheme.model.PlotSchemeModel;

@Repository
public class PlotSchemeDaoImpl implements PlotSchemeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Integer insertSchemeDetails(PlotSchemeModel plotSchemeModel) {
		String query = "insert into schememaster(schemeName) values(?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, plotSchemeModel.getSchemeName());
				return ps;
			}
		});
	}

	@Override
	public Integer insertPlotShopDetails(PlotSchemeModel plotSchemeModel) {
		String query = "insert into plot_shop_details(schemeId, plot_number, plotType, client_id, plotStatus) "
				+ "values(?,?,?,?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, plotSchemeModel.getSchemeId());
				ps.setInt(2, plotSchemeModel.getPlotNumber());
				ps.setString(3, plotSchemeModel.getPlotType());
				ps.setInt(4, plotSchemeModel.getClientId());
				ps.setString(5, "");
				return ps;
			}
		});
	}

	@Override
	public Integer updateSchemeDetails(PlotSchemeModel plotSchemeModel) {
		String query = "update schememaster set schemeName = ? where schemeId = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, plotSchemeModel.getSchemeName());
				ps.setInt(2, plotSchemeModel.getSchemeId());
				return ps;
			}
		});
	}

	@Override
	public List<PlotSchemeModel> getSchemeDetails() {
		String query = "select * from schememaster";
		return jdbcTemplate.query(query, new RowMapper<PlotSchemeModel>(){

			@Override
			public PlotSchemeModel mapRow(ResultSet rs, int arg1) throws SQLException {
				PlotSchemeModel psm = new PlotSchemeModel();
				psm.setSchemeId(rs.getInt("schemeId"));
				psm.setSchemeName(rs.getString("schemeName"));
				return psm;
			}
			
		});
	}

	@Override
	public List<PlotSchemeModel> getPlotShopDetails() {
		String query = "select * from plot_shop_details";
		return jdbcTemplate.query(query, new RowMapper<PlotSchemeModel>(){

			@Override
			public PlotSchemeModel mapRow(ResultSet rs, int arg1) throws SQLException {
				PlotSchemeModel psm  = new PlotSchemeModel();
				psm.setPlotId(rs.getInt("plot_id"));
				psm.setSchemeId(rs.getInt("schemeId"));
				psm.setPlotNumber(rs.getInt("plot_number"));
				psm.setPlotId(rs.getInt("client_id"));
				psm.setPlotType(rs.getString("plotType"));
				psm.setPlotStatus(rs.getString("plotStatus"));
				return psm;
			}
			
		});
	}

}
