package com.mirahelp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirahelp.domain.Corporation;
import com.mirahelp.repository.CorporationRepository;

@Service
public class CorporationService {

	@Autowired
	CorporationRepository corporationRepository;
	
	public Corporation saveCorporation(Corporation c) {
		if(c.getCategory() == null) {
			c.setCategory("Saúde");
		}
		corporationRepository.save(c);
		return c;
	}
	
	public List<Corporation> findaAllCorporations(){
		return corporationRepository.findAll();
	}
	
	public String deleteCorporation(String id) {
		Optional<Corporation> existCorp = corporationRepository.findById(id);
		if(existCorp.isPresent()) {
			corporationRepository.deleteById(id);
			return "Operação realisada com sucesso";
		} else {
			return "O registro não existe";
			
		}
	}
	
	public Optional<Corporation> findById(String id) {
		Optional<Corporation> findedCorp = corporationRepository.findById(id);
		
			return findedCorp;
		
	}
}
