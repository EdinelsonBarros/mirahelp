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
public class MedicalServiceController {

	@Autowired
	MedicalServiceService medicalServiceService;
	
	@PostMapping("/savemedicalservice")
	public String saveMedicalService( MedicalService m){
		MedicalService medicalServiceSaved = medicalServiceService.saveMedicalService(m);
		
		return "redirect:/corporationsList";
		
	}
}
