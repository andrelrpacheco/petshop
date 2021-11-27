package com.andre.petshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Functionary extends Person {

	private static final long serialVersionUID = 1L;
	
	private String function;
	
	@JsonIgnore
	@OneToMany(mappedBy = "functionary")
	List<ServiceOfPet> services = new ArrayList<>();
	
	public Functionary() {
		
	}

	public Functionary(Integer id, String name, String email, String nationalCode, String function) {
		super(id, name, email, nationalCode);
		this.function = function;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public List<ServiceOfPet> getServices() {
		return services;
	}

	public void setServices(List<ServiceOfPet> services) {
		this.services = services;
	}
}
