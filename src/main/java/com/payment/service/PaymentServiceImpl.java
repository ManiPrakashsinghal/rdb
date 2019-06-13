package com.payment.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.PaymentDao;
import com.payment.model.PaymentModel;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDao paymentDao;
	
	@Override
	public Integer insertPaymentDetails(PaymentModel paymentModel) {
		return paymentDao.insertPaymentDetails(paymentModel);
	}

	@Override
	public Integer updatePaymentDetails(PaymentModel paymentModel) {
		return paymentDao.updatePaymentDetails(paymentModel);
	}

	@Override
	public List<PaymentModel> getPaymentDetails(JSONObject jsonObject) {
		return paymentDao.getPaymentDetails(jsonObject);
	}

}
