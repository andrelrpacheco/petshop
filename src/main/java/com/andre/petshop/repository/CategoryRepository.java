package com.andre.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.petshop.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
