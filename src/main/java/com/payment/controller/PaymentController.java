package com.payment.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.PaymentModel;
import com.payment.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addPPaymentDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertPaymentDetailsMethod(@RequestBody PaymentModel paymentModel){
		JSONObject js= new JSONObject();
		try {
			int insertFlag = paymentService.insertPaymentDetails(paymentModel);
			if(insertFlag > 0){
				js.put("status", "200");
				js.put("message", "successfully submited");
			}else{
				js.put("status", "400");
				js.put("message", "please try again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			js.put("status", "500");
			js.put("message", "please try again");
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updatePPaymentDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updatePaymentDetailsMethod(@RequestBody PaymentModel paymentModel){
		JSONObject js= new JSONObject();
		try {
			int insertFlag = paymentService.updatePaymentDetails(paymentModel);
			if(insertFlag > 0){
				js.put("status", "200");
				js.put("message", "successfully updated");
			}else{
				js.put("status", "400");
				js.put("message", "please try again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			js.put("status", "500");
			js.put("message", "please try again");
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getPPaymentDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getPaymentDetailsMethod(@RequestBody JSONObject jsonObject){
		JSONObject js= new JSONObject();
		List<PaymentModel> list;
		try {
			list = paymentService.getPaymentDetails(jsonObject);
			if(!list.isEmpty()){
				js.put("status", "200");
				js.put("message", "successfully get");
				js.put("result", list);
			}else{
				js.put("status", "400");
				js.put("message", "please try again");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			js.put("status", "500");
			js.put("message", "please try again");
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
}
