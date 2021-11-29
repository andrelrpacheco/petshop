package com.andre.petshop.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.petshop.domain.Person;
import com.andre.petshop.dto.PersonDTO;
import com.andre.petshop.service.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {

	@Autowired
	PersonService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPersons(@PathVariable Integer id) {
		Person personData = service.personFind(id);
		
		return ResponseEntity.ok().body(personData);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createPerson(@RequestBody Person data) {
		
		data = service.createPerson(data);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePerson(@RequestBody Person data, @PathVariable Integer id) {
		
		data.setId(id);
		data = service.updatePerson(data);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removePerson(@PathVariable Integer id) {
		service.removePerson(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PersonDTO>> getAllPersons() {
		
		List<Person> listPerson = service.getAllPersons();
		List<PersonDTO> listPersonDTO = listPerson.stream().map(data -> new PersonDTO(data)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listPersonDTO);
	}
}
