package com.infy.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DTO.PlanDTO;
import com.infy.Service.PlanService;

@RestController
@RequestMapping("/")
public class PlanAPI {
	
	@Autowired
	PlanService service;
	
	@GetMapping("get/{planId}")
	public ResponseEntity<PlanDTO> getSpecificPlan(@PathVariable Integer planId){
		return new ResponseEntity<PlanDTO>(service.getSpecificPlan(planId), HttpStatus.OK);
	}

}
