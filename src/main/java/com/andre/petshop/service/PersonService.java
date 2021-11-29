package com.andre.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.andre.petshop.domain.Person;
import com.andre.petshop.repository.PersonRepository;
import com.andre.petshop.service.exceptions.DataIntegrityException;
import com.andre.petshop.service.exceptions.ObjectNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository accessRepository;
	
	public Person personFind(Integer id) {
		Optional<Person> personId = accessRepository.findById(id);
		return personId.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada!"));
	}
	
	public Person createPerson(Person data) {
		data.setId(null);
		return accessRepository.save(data);
	}
	
	public Person updatePerson(Person data) {
		personFind(data.getId());
		return accessRepository.save(data);
	}
	
	public void removePerson(Integer id) {
		personFind(id);
		try {
			accessRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pessoa não pode ser deletada!");
		}
	}
	
	public List<Person> getAllPersons() {
		
		return accessRepository.findAll();
	}
}
