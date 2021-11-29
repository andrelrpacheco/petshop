package com.andre.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.andre.petshop.domain.ServiceOfPet;
import com.andre.petshop.repository.ServiceRepository;
import com.andre.petshop.service.exceptions.DataIntegrityException;
import com.andre.petshop.service.exceptions.ObjectNotFoundException;

@Service
public class ListByIdService {
	
	@Autowired
	private ServiceRepository accessRepository;
	
	public ServiceOfPet findServiceOfPet(Integer id) {
		Optional<ServiceOfPet> serviceId = accessRepository.findById(id);
		return serviceId.orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado!"));
	}
	
	public ServiceOfPet createServiceOfPet(ServiceOfPet data) {
		data.setId(null);
		return accessRepository.save(data);
	}
	
	public ServiceOfPet updateServiceOfPet(ServiceOfPet data) {
		findServiceOfPet(data.getId());
		return accessRepository.save(data);
	}
	
	public void removeServiceOfPet(Integer id) {
		findServiceOfPet(id);
		try {
			accessRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Categoria possui produto, não é possível deletar!");
		}
	}
}
