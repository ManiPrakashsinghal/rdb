package com.payment.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.payment.model.PaymentModel;

public interface PaymentService {
	Integer insertPaymentDetails(PaymentModel paymentModel);
	Integer updatePaymentDetails(PaymentModel paymentModel);
	List<PaymentModel> getPaymentDetails(JSONObject jsonObject);
}
