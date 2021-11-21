package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.petshop.domain.Specie;

@Repository
public interface SpecieRepository extends JpaRepository<Specie, Integer>{

}
