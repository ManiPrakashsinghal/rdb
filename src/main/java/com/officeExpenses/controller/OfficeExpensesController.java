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

import com.officeExpenses.model.OfficeExpensesModel;
import com.officeExpenses.model.PayeeDetailsModel;
import com.officeExpenses.service.OfficeExpensesService;

@RestController
public class OfficeExpensesController {
	
	@Autowired
	OfficeExpensesService officeExpensesService;
	
	/**
	 * get All office Expenses*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getOfficeExpensesDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> listAllPayee(@RequestBody JSONObject jsonObject, UriComponentsBuilder ucbuilder){
		JSONObject js = new JSONObject();
		List<OfficeExpensesModel> officeExpensesModelReturn = null;
		try {
			officeExpensesModelReturn = officeExpensesService.getAllOfficeExpensesDetails(jsonObject);
			if(officeExpensesModelReturn.isEmpty()){
				js.put("status", "200");
				js.put("message", "No Content Found");
				return new ResponseEntity<JSONObject>(js,HttpStatus.NO_CONTENT);
			}else{
				js.put("status", "200");
				js.put("message", "Successfully Select All Data");
				js.put("allData", officeExpensesModelReturn);
			}
		} catch (Exception e) {
			js.put("status", "200");
			js.put("message", "Please try again");
			return new ResponseEntity<JSONObject>(js,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
	}
	
	/**
	 * insert payee details*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertOfficeExpensesDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertOfficeExpensesDetails(@RequestBody OfficeExpensesModel officeExpensesModel, UriComponentsBuilder ucBuilder){
		JSONObject js = new JSONObject();
		int flagInsertCheck = 0;
		try {
			flagInsertCheck = officeExpensesService.insertOfficeExpensesDetails(officeExpensesModel);
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
			System.out.println("exception "+e.getMessage());
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
	}
	
	/**
	 * update office expenses details*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateOfficeExpensesDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateOfficeExpensesDetails(@RequestBody OfficeExpensesModel officeExpensesModel, UriComponentsBuilder ucBuilder){
		JSONObject js = new JSONObject();
		int flagUdateCheck = 0;
		try {
			flagUdateCheck = officeExpensesService.updateOfficeExpensesDetails(officeExpensesModel);
			if(flagUdateCheck > 0){
				js.put("status", "200");
				js.put("message", "Successfully Updated");
			}else{
				js.put("status", "400");
				js.put("message", "Please Try Again");
			}
		} catch (Exception e) {
			js.put("status", "500");
			js.put("message", "Please Try Again");
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
	}
}
