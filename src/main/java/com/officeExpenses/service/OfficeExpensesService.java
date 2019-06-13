package com.officeExpenses.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.officeExpenses.model.OfficeExpensesModel;

public interface OfficeExpensesService {
	List<OfficeExpensesModel> getAllOfficeExpensesDetails(JSONObject jsonObject);
	Integer insertOfficeExpensesDetails(OfficeExpensesModel officeExpensesModel);
	Integer updateOfficeExpensesDetails(OfficeExpensesModel officeExpensesModel);
}
