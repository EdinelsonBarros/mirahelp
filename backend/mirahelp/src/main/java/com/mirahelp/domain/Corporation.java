package com.mirahelp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name =  "corporation")
@Table(name = "corporation")
public class Corporation {
	
	/*     
	 * Mudar nome da entidade para health unit
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String corporationId;
	
	private String name;
	
	private String category;
	
	private String street;
	private String numberAdress;
	private String neighborhood;
	
	private String hourOpening;
	private String hoursClose;
	/*
	 * alterar entidade
	 * adicionar atributo open(abre ás)
	 * adicionar atributo close(fecha ás)
	 * excluir atributo hours
	 * */
	
	private String phoneNumber;
	
	

	public Corporation(String name, String category, String street, String numberAdress, String neighborhood,
			String hourOpening, String hoursClose, String phoneNumber) {
		this.name = name;
		this.category = category;
		this.street = street;
		this.numberAdress = numberAdress;
		this.neighborhood = neighborhood;
		this.hourOpening = hourOpening;
		this.hoursClose = hoursClose;
		this.phoneNumber = phoneNumber;
	}
	public Corporation() {}
	public String getId() {
		return corporationId;
	}
/*
	public void setId(String id) {
		this.id = id;
	}
	
*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return numberAdress;
	}
	public void setNumber(String number) {
		this.numberAdress = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getHourOpening() {
		return hourOpening;
	}
	public void setHourOpening(String hourOpening) {
		this.hourOpening = hourOpening;
	}
	public String getHoursClose() {
		return hoursClose;
	}
	public void setHoursClose(String hoursClose) {
		this.hoursClose = hoursClose;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCorporationId() {
		return corporationId;
	}

	
	
	
	

}
