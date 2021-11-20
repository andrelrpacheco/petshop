package com.andre.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andre.petshop.domain.Category;
import com.andre.petshop.domain.Product;
import com.andre.petshop.repository.CategoryRepository;
import com.andre.petshop.repository.ProductRepository;

@Component
public class creatingData {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@PostConstruct
	public void register() {
		
		Category food = new Category(null, "Alimento");
		Category medicine = new Category(null, "Remédio");
		Category cosmetic = new Category(null, "Cosmético");
		
		Product p1 = new Product(null, "Ração", 100.0);
		Product p2 = new Product(null, "Sache", 80.0);
		Product p3 = new Product(null, "Vermifugo", 20.0);
		Product p4 = new Product(null, "Shampoo", 50.0);
		
		food.getProducts().addAll(Arrays.asList(p1, p2));
		medicine.getProducts().addAll(Arrays.asList(p3, p4));
		cosmetic.getProducts().addAll(Arrays.asList(p4));
		
		p1.getCategories().addAll(Arrays.asList(food));
		p2.getCategories().addAll(Arrays.asList(food));
		p3.getCategories().addAll(Arrays.asList(medicine));
		p4.getCategories().addAll(Arrays.asList(medicine, cosmetic));
		
		categoryRepository.saveAll(Arrays.asList(food, medicine, cosmetic));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}
}
