package com.officeExpenses.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.officeExpenses.Dao.OfficeExpensesDao;
import com.officeExpenses.model.OfficeExpensesModel;

@Service("officeExpensesServiceImpl")
public class OfficeExpensesServiceImpl implements OfficeExpensesService{

	@Autowired
	OfficeExpensesDao officeExpensesDao;
	@Override
	public List<OfficeExpensesModel> getAllOfficeExpensesDetails(JSONObject jsonObject) {
		return officeExpensesDao.getAllOfficeExpensesDetails(jsonObject);
	}
	@Override
	public Integer insertOfficeExpensesDetails(OfficeExpensesModel officeExpensesModel) {
		return officeExpensesDao.insertOfficeExpensesDetails(officeExpensesModel);
	}
	@Override
	public Integer updateOfficeExpensesDetails(OfficeExpensesModel officeExpensesModel) {
		return officeExpensesDao.updateOfficeExpensesDetails(officeExpensesModel);
	}

}
