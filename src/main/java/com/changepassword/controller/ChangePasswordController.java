package com.changepassword.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.changepassword.model.ChangePasswordModel;
import com.changepassword.service.ChangePasswordService;

@RestController
public class ChangePasswordController {
	
	@Autowired
	ChangePasswordService changePasswordService;
	
	@RequestMapping(value = "/setChangePassword", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> changePassword(@RequestBody ChangePasswordModel changePasswordModel, UriComponentsBuilder ucBuilder){
		JSONObject js = new JSONObject();
		int changePasswordFlag = changePasswordService.changePassword(changePasswordModel);
		
		if(changePasswordFlag > 0){
			js.put("success", "Successfully Changed");
			js.put("status", "200");
		}else{
			js.put("status", "400");
		}
		return new ResponseEntity<JSONObject>(js , HttpStatus.OK);
		
	}
}
