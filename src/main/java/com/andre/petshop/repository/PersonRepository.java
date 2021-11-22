package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.petshop.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
