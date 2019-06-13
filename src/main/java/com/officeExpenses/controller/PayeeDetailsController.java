package com.officeExpenses.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.officeExpenses.model.PayeeDetailsModel;
import com.officeExpenses.service.PayeeDetailsServices;

@RestController
public class PayeeDetailsController {
	
	@Autowired
	PayeeDetailsServices payeeDetailsServices;
	/**
	 * get All PayeeDetails*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getPayeeDetails", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> listAllPayee(){
		JSONObject js = new JSONObject();
		List<PayeeDetailsModel> payeeDetailsModels = null;
		try {
			payeeDetailsModels = payeeDetailsServices.getAllPayeeDetails();
			if(payeeDetailsModels.isEmpty()){
				js.put("status", "200");
				js.put("message", "No Content Found");
				return new ResponseEntity<JSONObject>(js,HttpStatus.NO_CONTENT);
			}else{
				js.put("status", "200");
				js.put("message", "Successfully Select All Data");
				js.put("allData", payeeDetailsModels);
			}
		} catch (Exception e) {
			js.put("status", "200");
			js.put("message", "Please Try Again");
			return new ResponseEntity<JSONObject>(js,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
	}
	
	/**
	 * insert payee details*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/payeeDetailsInsert", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertPayeeDetails(@RequestBody PayeeDetailsModel payeeDetailsModel, UriComponentsBuilder ucBuilder){
		JSONObject js = new JSONObject();
		int flagInsertCheck = 0;
		try {
			flagInsertCheck = payeeDetailsServices.insertPayeeDetails(payeeDetailsModel);
			if(flagInsertCheck > 0){
				js.put("status", "200");
				js.put("message", "Successfully Submitted");
			}else{
				js.put("status", "400");
				js.put("message", "Please Try Again");
			}
		} catch (Exception e) {
			js.put("status", "500");
			js.put("message", "Please Try Again");
			return new ResponseEntity<JSONObject>(js,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<JSONObject>(js,HttpStatus.OK);
	}
	
	/**
	 * update payee details*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/payeeDetailsUpdate", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updatePayeeDetails(@RequestBody PayeeDetailsModel payeeDetailsModel, UriComponentsBuilder ucBuilder){
		JSONObject js = new JSONObject();
		int flagUpdateCheck = 0;
		try {
			flagUpdateCheck = payeeDetailsServices.updatePayeeDetails(payeeDetailsModel);
			if(flagUpdateCheck > 0){
				js.put("status", "200");
				js.put("message", "Successfully Updated");
			}else{
				js.put("status", "400");
				js.put("message", "Please Try Again");
				return new ResponseEntity<>(js, HttpStatus.OK);
			}
		} catch (Exception e) {
			js.put("status", "500");
			js.put("message", "Please Try Again");
			return new ResponseEntity<>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(js, HttpStatus.OK);
	}
}
