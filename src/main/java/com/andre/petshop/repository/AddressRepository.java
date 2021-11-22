package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.petshop.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
