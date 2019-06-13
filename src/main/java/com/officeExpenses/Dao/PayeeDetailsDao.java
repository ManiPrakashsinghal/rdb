package com.officeExpenses.Dao;

import java.util.List;

import com.officeExpenses.model.PayeeDetailsModel;

public interface PayeeDetailsDao {
	List<PayeeDetailsModel> getAllPayeeDetailsDao();
	Integer insertPayeeDetails(PayeeDetailsModel payeeDetailsModel);
	Integer updatePayeeDetails(PayeeDetailsModel payeeDetailsModel);
}
