package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.petshop.domain.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>{

}
