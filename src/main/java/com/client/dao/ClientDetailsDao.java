package com.client.dao;

import java.util.List;

import org.json.simple.JSONObject;

import com.client.model.ClientModel;

public interface ClientDetailsDao {
	Integer insertClientBasicDetails(ClientModel clientModel);
	Integer insertClientFinanceDetails(ClientModel clientModel);
	Integer insertClientRealEstateDetails(ClientModel clientModel);
	Integer updateClientBasicDetails(ClientModel clientModel);
	Integer updateClientFinanceDetails(ClientModel clientModel);
	Integer updateClientRealEstateDetails(ClientModel clientModel);
	Integer updatePlotDetails(ClientModel clientModel, String plotNumber, String plotType);
	List<ClientModel> getFinanceClientDetails(JSONObject jsonObject);
	List<ClientModel> getRealEstateClientDetails(JSONObject jsonObject);
	List<ClientModel> getPlotDetails(ClientModel clientModel);
}
