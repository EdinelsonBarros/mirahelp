package com.mirahelp.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "medical_service")
@Table(name = "medical_service")
public class MedicalService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String medicalServiceId;
	
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "corporationId")
	private Corporation healthUnit;
	
	// usar array para escolher os dias da semana e converter para string para gravar  no db
	
	private String dayWeek;
	
	private String serviceStarts;
	
	private String serviceEnds;

	public MedicalService(String name, Corporation healthUnit, String dayWeek, String serviceStarts, String serviceEnds) {
		this.name = name;
		this.healthUnit = healthUnit;
		this.dayWeek = dayWeek;
		this.serviceStarts = serviceStarts;
		this.serviceEnds = serviceEnds;
	}

	public MedicalService() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Corporation getHealthUnit() {
		return healthUnit;
	}

	public void setHealthUnit(Corporation healthUnit) {
		this.healthUnit = healthUnit;
	}

	public String getDayWeek() {
		return dayWeek;
	}

	public void setDayWeek(String dayWeek) {
		this.dayWeek = dayWeek;
	}

	public String getServiceStarts() {
		return serviceStarts;
	}

	public void setServiceStarts(String serviceStarts) {
		this.serviceStarts = serviceStarts;
	}

	public String getServiceEnds() {
		return serviceEnds;
	}

	public void setServiceEnds(String serviceEnds) {
		this.serviceEnds = serviceEnds;
	}

	public String getId() {
		return medicalServiceId;
	}
	
	
	
	
	
	

}
