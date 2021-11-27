package com.andre.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
