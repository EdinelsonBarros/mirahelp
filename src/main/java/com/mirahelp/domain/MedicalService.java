package com.mirahelp.domain;

import java.util.Objects;

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
	
	private String[] daysWeek = new String[7];
	
	private String serviceStarts;
	
	private String serviceEnds;



	public MedicalService(String medicalServiceId, String name, Corporation healthUnit, String dayWeek,
			String[] daysWeek, String serviceStarts, String serviceEnds) {
		
		this.medicalServiceId = medicalServiceId;
		this.name = name;
		this.healthUnit = healthUnit;
		this.dayWeek = dayWeek;
		this.daysWeek = daysWeek;
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

	public String getMedicalServiceId() {
		return medicalServiceId;
	}

	public void setMedicalServiceId(String medicalServiceId) {
		this.medicalServiceId = medicalServiceId;
	}

	public String[] getDaysWeek() {
		return daysWeek;
	}

	public void setDaysWeek(String[] daysWeek) {
		this.daysWeek = daysWeek;
	}

	@Override
	public int hashCode() {
		return Objects.hash(healthUnit, medicalServiceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalService other = (MedicalService) obj;
		return Objects.equals(healthUnit, other.healthUnit) && Objects.equals(medicalServiceId, other.medicalServiceId);
	}
	
	
	
	
	
	

}
