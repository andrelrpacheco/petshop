package com.andre.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andre.petshop.domain.Category;
import com.andre.petshop.repositories.CategoryRepository;

@Component
public class creatingData {

	@Autowired
	CategoryRepository categoryRepository;
	
	@PostConstruct
	public void register() {
		
		Category food = new Category(null, "Alimento");
		Category cosmetic = new Category(null, "Cosmético");
		Category medicine = new Category(null, "Remédio");
		
		categoryRepository.saveAll(Arrays.asList(food, cosmetic, medicine));
	}
}
