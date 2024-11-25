package com.mirahelp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirahelp.domain.Corporation;
import com.mirahelp.domain.MedicalService;
import com.mirahelp.repository.MedicalServiceRepository;

@Service
public class MedicalServiceService {

	@Autowired
	MedicalServiceRepository medicalServiceRepository;

	public MedicalService saveMedicalService(MedicalService m) {
		medicalServiceRepository.save(m);
		return m;
	}

	public List<MedicalService> findAllMedicalServices() {
		List<MedicalService> medicalServices = medicalServiceRepository.findAll();
		return medicalServices;
	}

	public List<MedicalService> findMedicalServicesByCorporationId(Corporation corp) {
		List<MedicalService> medicalServices = medicalServiceRepository.findAll().stream()
				.filter(ms -> ms.getHealthUnit().equals(corp)).toList();
		return medicalServices;
	}

	public MedicalService updateMedicalService(MedicalService m) {
		Optional<MedicalService> medicalService = medicalServiceRepository.findById(m.getId());
		if (medicalService.isPresent()) {
			medicalService.get().setName(m.getName());
			medicalService.get().setDayWeek(m.getDayWeek());
			medicalService.get().setHealthUnit(m.getHealthUnit());
			medicalService.get().setServiceStarts(m.getServiceStarts());
			medicalService.get().setServiceEnds(m.getServiceEnds());
			return medicalService.get();
		}

		return m;
	}

	public String deleteMedicalService(String medicalServiceId) {
		medicalServiceRepository.deleteById(medicalServiceId);

		return "Deletado com sucesso.";
	}

}
