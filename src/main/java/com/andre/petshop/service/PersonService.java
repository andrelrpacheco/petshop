package com.andre.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.petshop.domain.Person;
import com.andre.petshop.repository.PersonRepository;
import com.andre.petshop.service.exceptions.ObjectNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository accessRepository;
	
	public Person personFind(Integer id) {
		Optional<Person> personId = accessRepository.findById(id);
		return personId.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. ID: " + id + ", Tipo: " + Person.class.getName()));
	}
}
