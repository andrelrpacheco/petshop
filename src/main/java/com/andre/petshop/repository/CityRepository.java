package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andre.petshop.domain.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
