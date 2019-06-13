package com.plotScheme.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.plotScheme.model.PlotSchemeModel;
import com.plotScheme.service.PlotSchemeService;

@RestController
public class PlotSchemeController {
	
	@Autowired
	PlotSchemeService plotSchemeService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertPsSchemeDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertSchemeDetailsMethod(@RequestBody PlotSchemeModel plotSchemeModel){
		JSONObject js = new JSONObject();
		System.out.println("plot "+plotSchemeModel);
		try {
			int schemeFlag = plotSchemeService.insertSchemeDetails(plotSchemeModel);
			if(schemeFlag > 0){
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
	@RequestMapping(value = "/updatePsSchemeDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateSchemeDetailsMethod(@RequestBody PlotSchemeModel plotSchemeModel){
		JSONObject js = new JSONObject();
		try {
			int updateSchemeFlag = plotSchemeService.updateSchemeDetails(plotSchemeModel);
			if(updateSchemeFlag > 0){
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
			return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getPsSchemeDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getSchemeDetailsMethod(){
		JSONObject js = new JSONObject();
		List<PlotSchemeModel> list = null;
		try {
			list = plotSchemeService.getSchemeDetails();
			if(!list.isEmpty()){
				js.put("status", "200");
				js.put("message", "successfully get");
				js.put("result", list);
			}else{
				js.put("status", "200");
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
	@RequestMapping(value = "/getPsPlotDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getPlotDeatilsMethod(){
		JSONObject js = new JSONObject();
		List<PlotSchemeModel> list = null;
		try {
			list = plotSchemeService.getPlotShopDetails();
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
			return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		}
		return new ResponseEntity<JSONObject>(js, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addPsPlotShopDetails", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> insertPlotDetailsMethod(@RequestBody PlotSchemeModel plotSchemeModel){
		JSONObject js  = new JSONObject();
		try {
			int  insertFlag = 0;
			int minPlot     = plotSchemeModel.getMinPlotNumber();
			int maxPlot     = plotSchemeModel.getMaxPlotNumber();
			for(int i = minPlot; i <= maxPlot; i++){
				plotSchemeModel.setPlotNumber(i);
				insertFlag  = plotSchemeService.insertPlotShopDetails(plotSchemeModel);
			}
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
}
