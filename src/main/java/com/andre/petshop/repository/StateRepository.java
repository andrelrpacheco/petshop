package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andre.petshop.domain.State;

public interface StateRepository extends JpaRepository<State, Integer> {

}
