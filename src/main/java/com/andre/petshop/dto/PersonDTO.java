package com.andre.petshop.dto;

import java.io.Serializable;

import com.andre.petshop.domain.Person;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String nationalCode;
	
	public PersonDTO() {
		
	}

	public PersonDTO(Person data) {
		this.name = data.getName();
		this.email = data.getEmail();
		this.nationalCode = data.getNationalCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}
}
