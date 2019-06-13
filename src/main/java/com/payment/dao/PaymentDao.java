package com.payment.dao;

import java.util.List;

import org.json.simple.JSONObject;

import com.payment.model.PaymentModel;

public interface PaymentDao {

	Integer insertPaymentDetails(PaymentModel paymentModel);
	Integer updatePaymentDetails(PaymentModel paymentModel);
	List<PaymentModel> getPaymentDetails(JSONObject jsonObject);
}
