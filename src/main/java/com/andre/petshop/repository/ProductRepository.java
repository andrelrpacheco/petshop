package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.petshop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
