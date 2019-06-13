package com.officeExpenses.service;

import java.util.List;

import com.officeExpenses.model.PayeeDetailsModel;

public interface PayeeDetailsServices {
	List<PayeeDetailsModel> getAllPayeeDetails();
	Integer insertPayeeDetails(PayeeDetailsModel payeeDetailsModel);
	Integer updatePayeeDetails(PayeeDetailsModel payeeDetailsModel);
}
