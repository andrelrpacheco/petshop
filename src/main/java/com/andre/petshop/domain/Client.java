package com.andre.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Client extends Person {

	private static final long serialVersionUID = 1L;
	
	private String type;
	
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
}
