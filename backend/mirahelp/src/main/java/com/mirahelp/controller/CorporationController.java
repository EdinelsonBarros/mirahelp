package com.mirahelp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mirahelp.domain.Corporation;
import com.mirahelp.service.CorporationService;


@Controller
@RequestMapping("/corporation")
public class CorporationController {
	
	@Autowired
	CorporationService corporationService;
	
	@PostMapping("/save")
	public ResponseEntity<Corporation> saveCorporation(@RequestBody Corporation c){
		var corpSaved =  corporationService.saveCorporation(c);
		
		return ResponseEntity.ok(corpSaved);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Corporation>> getAllCorporations(){
		List corporation = corporationService.findaAllCorporations();
		
		return ResponseEntity.ok(corporation);
	}

}
