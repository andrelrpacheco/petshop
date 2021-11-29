package com.andre.petshop.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.petshop.domain.ServiceOfPet;
import com.andre.petshop.service.ListByIdService;

@RestController
@RequestMapping(value = "/services")
public class ServiceOfPetResource {

	@Autowired
	ListByIdService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getServicesById(@PathVariable Integer id) {
		ServiceOfPet serviceData = service.findServiceOfPet(id);
		
		return ResponseEntity.ok().body(serviceData);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createServiceOfPet(@RequestBody ServiceOfPet data) {
		
		data = service.createServiceOfPet(data);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateServiceOfPet(@RequestBody ServiceOfPet data, @PathVariable Integer id) {
		
		data.setId(id);
		data = service.updateServiceOfPet(data);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeServiceOfPet(@PathVariable Integer id) {
		service.removeServiceOfPet(id);
		return ResponseEntity.noContent().build();
	}
}
