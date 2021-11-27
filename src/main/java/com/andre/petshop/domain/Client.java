package com.andre.petshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client extends Person {

	private static final long serialVersionUID = 1L;
	
	private String type;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	List<ServiceOfPet> services = new ArrayList<>();
	
	public Client() {
		
	}

	public Client(Integer id, String name, String email, String nationalCode, String type) {
		super(id, name, email, nationalCode);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ServiceOfPet> getServices() {
		return services;
	}

	public void setServices(List<ServiceOfPet> services) {
		this.services = services;
	}
}
