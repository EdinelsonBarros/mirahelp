package com.mirahelp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mirahelp.domain.Corporation;
import com.mirahelp.domain.Days;
import com.mirahelp.domain.MedicalService;
import com.mirahelp.service.CorporationService;
import com.mirahelp.service.MedicalServiceService;


@Controller
public class CorporationController {
	
	@Autowired
	CorporationService corporationService;
	
	@Autowired
	MedicalServiceService medicalServiceService;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	
	
	@GetMapping("/createCorporation")
	public String create() {
		return "createCorporation";
	}
	
	@ModelAttribute("multiCheckboxAllValues") 
	public String[] getMultiCheckboxAllValues() { 
	    return new String[] { 
	        "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", "Domingo" 
	    }; 
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView details(@PathVariable("id") String id) {
		Optional<Corporation> corpFinded = corporationService.findById(id);
		ModelAndView mv = new ModelAndView("details");
		MedicalService ms = new MedicalService();
		
		List<MedicalService> msList = medicalServiceService.findMedicalServicesByCorporationId(corpFinded.get());
		mv.addObject("corporation", corpFinded.get());
		mv.addObject("serviceArray", msList.iterator());
		ms.setHealthUnit(corpFinded.get());
		mv.addObject("medicalService",ms);
		return mv;
	}
	
	@PostMapping("/save")
	public String saveCorporation(Corporation c){
		var corpSaved =  corporationService.saveCorporation(c);
		
		return "redirect:/corporationsList";
		//Fazer controler para retornar pagina inicial
	}
	
	@GetMapping("/corporationsList")
	public ModelAndView getAllCorporations(){
		ModelAndView modelAndView = new ModelAndView("corporationsList");
		List corporationsList = corporationService.findaAllCorporations();
		modelAndView.addObject("CorporationsList", corporationsList);
		
		return modelAndView;
	}

}
