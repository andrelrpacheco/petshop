package com.andre.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Functionary extends Person {

	private static final long serialVersionUID = 1L;
	
	private String function;
	
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
}
