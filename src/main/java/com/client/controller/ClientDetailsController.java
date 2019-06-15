package com.client.controller;

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

import com.client.model.ClientModel;
import com.client.service.ClientDetailsService;

@RestController
public class ClientDetailsController {

	@Autowired
	ClientDetailsService clientDetailsService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addClientDetails" , method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertClientDetails(@RequestBody ClientModel clientModel, UriComponentsBuilder ucBuilder){
		JSONObject js = new JSONObject();
		int clientPrimaryId = 0;
		/**
		 * client type
		 * 0 for finance
		 * 1 for real estate*/
		try {
			
			if(clientModel.getClientType() == 1){
				if(clientDetailsService.getClientDetailsByMobileSchemeId(clientModel.getRealStateClientMobile(), clientModel.getSchemeId()) > 0){
					
					js.put("status", "400");
					js.put("message", "Mobile Number & Scheme Name Already Exists");
					return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
				}
			}
			clientPrimaryId = clientDetailsService.insertClientBasicDetails(clientModel);
			clientModel.setClient_id(clientPrimaryId);
			if(clientPrimaryId > 0){
				if(clientModel.getClientType() == 0){
					int clientFinanceFlag = clientDetailsService.insertClientFinanceDetails(clientModel);
					if(clientFinanceFlag > 0){
						js.put("status", "200");
						js.put("message", "Successfull Submited");
					}else{
						js.put("status", "400");
						js.put("message", "Please Try Again");
					}
				}else if(clientModel.getClientType() == 1){
					
					int clientRealEstateFlag = clientDetailsService.insertClientRealEstateDetails(clientModel);
					String[] plotNumberArray = clientModel.getPlotNumber().split(",");
					String[] shopnumberArray = clientModel.getShopNumber().split(",");
					int plotArrayLength = plotNumberArray.length;
					int shopArrayLength = shopnumberArray.length;

					if(plotArrayLength > 0){
						for(String pNumber : plotNumberArray){
							clientDetailsService.updatePlotDetails(clientModel, pNumber, "p");
						}
						
					}
					if(shopArrayLength > 0){
						for(String sNumber : shopnumberArray){
							clientDetailsService.updatePlotDetails(clientModel, sNumber, "s");
						}
						
					}
					
					if(clientRealEstateFlag > 0){
						js.put("status", "200");
						js.put("message", "Successfull Submited");
					}else{
						js.put("status", "400");
						js.put("message", "Please Try Again");
					}
				}
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
	@RequestMapping(value = "/getFinanceClientList", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getAllFinanceClientList(@RequestBody JSONObject jsonObject){
		JSONObject js = new JSONObject();
		List<ClientModel> clientList = null;
		try {
			clientList = clientDetailsService.getFinanceClientDetails(jsonObject);
			if(clientList.isEmpty()){
				js.put("status", "200");
				js.put("message", "No Content Found");
			}else{
				js.put("status", "200");
				js.put("message", "SuccessFully Get All Data");
				js.put("result", clientList);
			}
		} catch (Exception e) {
			js.put("status", "200");
			js.put("message", "Please Try Again");
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getRealEstateClientList", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getAllRealStateClientList(@RequestBody JSONObject jsonObject){
		JSONObject js = new JSONObject();
		List<ClientModel> clientList = null;
		try {
			clientList = clientDetailsService.getRealEstateClientDetails(jsonObject);
			if(clientList.isEmpty()){
				js.put("status", "200");
				js.put("message", "No Content Found");
			}else{
				
				js.put("status", "200");
				js.put("message", "SuccessFully Get All Data");
				js.put("result", clientList);
			}
		} catch (Exception e) {
			js.put("status", "200");
			js.put("message", "Please Try Again");
			return new ResponseEntity<JSONObject>(js, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateFinanceClientData", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateFinanceClientDataMethod(@RequestBody ClientModel clientModel){
		JSONObject js = new JSONObject();
		try {
			int checkBasicFlag = clientDetailsService.updateClientBasicDetails(clientModel);
			if(checkBasicFlag > 0){
				int checkRealEstateFlag = clientDetailsService.updateClientFinanceDetails(clientModel);
				if(checkRealEstateFlag > 0){
					js.put("status", "200");
					js.put("message", "successfully updated");
				}else{
					js.put("status", "400");
					js.put("message", "please try again");
				}
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
	@RequestMapping(value = "/updateRealEstateClientData", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateRealEstateClientDataMethod(@RequestBody ClientModel clientModel){
		JSONObject js = new JSONObject();
		try {
			int checkBasicFlag = clientDetailsService.updateClientBasicDetails(clientModel);
			if(checkBasicFlag > 0){
				int checkRealEstateFlag = clientDetailsService.updateClientRealEstateDetails(clientModel);
				if(checkRealEstateFlag > 0){
					js.put("status", "200");
					js.put("message", "successfully updated");
				}else{
					js.put("status", "400");
					js.put("message", "please try again");
				}
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
