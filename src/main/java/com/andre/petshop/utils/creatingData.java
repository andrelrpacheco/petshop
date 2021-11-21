package com.andre.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andre.petshop.domain.Category;
import com.andre.petshop.domain.Pet;
import com.andre.petshop.domain.Product;
import com.andre.petshop.domain.Race;
import com.andre.petshop.domain.Specie;
import com.andre.petshop.repository.CategoryRepository;
import com.andre.petshop.repository.PetRepository;
import com.andre.petshop.repository.ProductRepository;
import com.andre.petshop.repository.RaceRepository;
import com.andre.petshop.repository.SpecieRepository;

@Component
public class creatingData {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	SpecieRepository specieRepository;
	
	@Autowired
	RaceRepository raceRepository;
	
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
		
		Specie dog = new Specie(null, "Cachorro");
		Specie cat = new Specie(null, "Gato");
		
		Race rac1 = new Race(null, "Shitzu");
		Race rac2 = new Race(null, "Akita");
		Race rac3 = new Race(null, "Persa");
		
		Pet pet1 = new Pet(null, "Jonh", 6, dog, rac1);
		Pet pet2 = new Pet(null, "Hana", 5, dog, rac2);
		Pet pet3 = new Pet(null, "Mewth", 8, cat, rac3);
		
		specieRepository.saveAll(Arrays.asList(dog, cat));
		raceRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
		petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));
	}
}
