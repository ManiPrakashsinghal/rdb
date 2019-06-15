package com.client.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.dao.ClientDetailsDao;
import com.client.model.ClientModel;

@Service("clientDetailsServiceImpl")
public class ClientDetailsServiceImpl implements ClientDetailsService{

	@Autowired
	ClientDetailsDao clientDetailsDao;

	@Override
	public Integer insertClientBasicDetails(ClientModel clientModel) {
		return clientDetailsDao.insertClientBasicDetails(clientModel);
	}

	@Override
	public Integer insertClientFinanceDetails(ClientModel clientModel) {
		return clientDetailsDao.insertClientFinanceDetails(clientModel);
	}

	@Override
	public Integer insertClientRealEstateDetails(ClientModel clientModel) {
		return clientDetailsDao.insertClientRealEstateDetails(clientModel);
	}

	@Override
	public Integer updateClientBasicDetails(ClientModel clientModel) {
		return clientDetailsDao.updateClientBasicDetails(clientModel);
	}

	@Override
	public Integer updateClientFinanceDetails(ClientModel clientModel) {
		return clientDetailsDao.updateClientFinanceDetails(clientModel);
	}

	@Override
	public Integer updateClientRealEstateDetails(ClientModel clientModel) {
		return clientDetailsDao.updateClientRealEstateDetails(clientModel);
	}

	@Override
	public Integer updatePlotDetails(ClientModel clientModel, String plotNumber, String plotType) {
		return clientDetailsDao.updatePlotDetails(clientModel, plotNumber, plotType);
	}

	@Override
	public List<ClientModel> getFinanceClientDetails(JSONObject jsonObject) {
		return clientDetailsDao.getFinanceClientDetails(jsonObject);
	}

	@Override
	public List<ClientModel> getRealEstateClientDetails(JSONObject jsonObject) {
		return clientDetailsDao.getRealEstateClientDetails(jsonObject);
	}

	@Override
	public List<String> getPlotDetails(int clientId, String plotType) {
		return clientDetailsDao.getPlotDetails(clientId, plotType);
	}

	@Override
	public Integer insertClientDocoment(String imageName, int clientId) {
		return clientDetailsDao.insertClientDocoment(imageName, clientId);
	}

	@Override
	public Integer getClientDetailsByMobileSchemeId(String mobileNumber, String schemeId) {
		return clientDetailsDao.getClientDetailsByMobileSchemeId(mobileNumber, schemeId);
	}
	


}
