package com.mirahelp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mirahelp.domain.MedicalService;
import com.mirahelp.service.MedicalServiceService;

@Controller
@RequestMapping("/medical")
public class MedicalServiceController {

	@Autowired
	MedicalServiceService medicalServiceService;
	
	@PostMapping("/save")
	public ResponseEntity saveMedicalService(@RequestBody MedicalService m){
		MedicalService medicalServiceSaved = medicalServiceService.saveMedicalService(m);
		
		return ResponseEntity.ok().build();
		
	}
}
