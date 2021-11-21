package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.petshop.domain.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer>{

}
