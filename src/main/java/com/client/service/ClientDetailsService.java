package com.client.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.client.model.ClientModel;

public interface ClientDetailsService {
	Integer insertClientBasicDetails(ClientModel clientModel);
	Integer insertClientFinanceDetails(ClientModel clientModel);
	Integer insertClientRealEstateDetails(ClientModel clientModel);
	Integer updateClientBasicDetails(ClientModel clientModel);
	Integer updateClientFinanceDetails(ClientModel clientModel);
	Integer updateClientRealEstateDetails(ClientModel clientModel);
	Integer updatePlotDetails(ClientModel clientModel, String plotNumber, String plotType);
	List<ClientModel> getFinanceClientDetails(JSONObject jsonObject);
	List<ClientModel> getRealEstateClientDetails(JSONObject jsonObject);
	List<String> getPlotDetails(int clientId, String plotType);
	
	Integer insertClientDocoment(String imageName, int clientId);
	Integer getClientDetailsByMobileSchemeId(String mobileNumber, String schemeId);
}
