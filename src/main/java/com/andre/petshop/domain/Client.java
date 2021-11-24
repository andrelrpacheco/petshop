package com.andre.petshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends Person {

	private static final long serialVersionUID = 1L;
	
	private String type;
	
	@OneToMany(mappedBy = "client")
	List<Service> services = new ArrayList<>();
	
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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}
