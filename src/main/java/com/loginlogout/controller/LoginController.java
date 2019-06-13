package com.loginlogout.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loginlogout.model.LoginModel;
import com.loginlogout.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> loginUser(@RequestBody LoginModel loginModel){
		JSONObject js = new JSONObject();
		try {
			List<LoginModel> list = loginService.loginUser(loginModel);
			if(list.isEmpty()){
				js.put("status", "200");
				js.put("message", "UserName/password Worng");
				return new ResponseEntity<JSONObject>(js, HttpStatus.BAD_REQUEST);
			}else{
				js.put("status", "200");
				js.put("message", "SuccessFully Login");
			}
		} catch (Exception e) {
			js.put("status", "500");
			js.put("message", "Please try Again");
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
}
