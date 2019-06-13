package com.officeExpenses.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.officeExpenses.Dao.PayeeDetailsDao;
import com.officeExpenses.model.PayeeDetailsModel;

@Service("payeeDetailsServicesImpl")
public class PayeeDetailsServicesImpl implements PayeeDetailsServices{

	@Autowired
	PayeeDetailsDao payeeDetailsDao;
	public List<PayeeDetailsModel> getAllPayeeDetails() {
		System.out.println("service "+ payeeDetailsDao.getAllPayeeDetailsDao());
		
		return payeeDetailsDao.getAllPayeeDetailsDao();
		
	}
	
	@Override
	public Integer insertPayeeDetails(PayeeDetailsModel payeeDetailsModel) {
		return payeeDetailsDao.insertPayeeDetails(payeeDetailsModel);
	}

	@Override
	public Integer updatePayeeDetails(PayeeDetailsModel payeeDetailsModel) {
		return payeeDetailsDao.updatePayeeDetails(payeeDetailsModel);
	}

}
