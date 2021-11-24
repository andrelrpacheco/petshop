package com.andre.petshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andre.petshop.domain.Address;
import com.andre.petshop.domain.Category;
import com.andre.petshop.domain.City;
import com.andre.petshop.domain.Client;
import com.andre.petshop.domain.Functionary;
import com.andre.petshop.domain.Payment;
import com.andre.petshop.domain.PaymentInCard;
import com.andre.petshop.domain.PaymentInMoney;
import com.andre.petshop.domain.Pet;
import com.andre.petshop.domain.Product;
import com.andre.petshop.domain.Race;
import com.andre.petshop.domain.Service;
import com.andre.petshop.domain.Specie;
import com.andre.petshop.domain.State;
import com.andre.petshop.domain.enums.StatusPayment;
import com.andre.petshop.repository.AddressRepository;
import com.andre.petshop.repository.CategoryRepository;
import com.andre.petshop.repository.CityRepository;
import com.andre.petshop.repository.PaymentRepository;
import com.andre.petshop.repository.PersonRepository;
import com.andre.petshop.repository.PetRepository;
import com.andre.petshop.repository.ProductRepository;
import com.andre.petshop.repository.RaceRepository;
import com.andre.petshop.repository.ServiceRepository;
import com.andre.petshop.repository.SpecieRepository;
import com.andre.petshop.repository.StateRepository;

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
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	
	@PostConstruct
	public void register() throws ParseException {
		
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
		
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");
		
		City cit1 = new City(null, "Belo Horizonte", est1);
		City cit2 = new City(null, "Capelinha", est1);
		City cit3 = new City(null, "São Paulo", est2);
		
		est1.getCities().addAll(Arrays.asList(cit1, cit2));
		est2.getCities().addAll(Arrays.asList(cit3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(cit1, cit2, cit3));
		
		Client clt1 = new Client(null, "Jose Maria", "josemaria@teste.com", "333.333.333-33", "Física");
		clt1.getTelephone().addAll(Arrays.asList("3516-2000", "99191-0000"));
		
		Functionary func1 = new Functionary(null, "Maria Jose", "mariajose@teste.com", "555.555.555-55", "Atendente");
		func1.getTelephone().addAll(Arrays.asList("3279-0001", "99090-0002"));
		
		Address end1 = new Address(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30110-222", clt1, cit1);
		Address end2 = new Address(null, "Av. Tamoios", "100", "Casa", "Oca", "39680-000", func1, cit2);
		Address end3 = new Address(null, "Rua Arañas", "10", "Apto 201", "Centro", "01153-000", func1, cit3);
		
		personRepository.saveAll(Arrays.asList(clt1, func1));
		addressRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Service srv1 = new Service(null, simpleDateFormat.parse("02/09/2021 09:00"), simpleDateFormat.parse("02/09/2021 12:00"), "Tosa", clt1, func1, pet1);
		Service srv2 = new Service(null, simpleDateFormat.parse("03/09/2021 12:00"), simpleDateFormat.parse("04/09/2021 12:00"), "Hotel", clt1, func1, pet2);
		Service srv3 = new Service(null, simpleDateFormat.parse("05/09/2021 16:00"), simpleDateFormat.parse("05/09/2021 16:30"), "Vermifugação", clt1, func1, pet3);
		
		Payment pgt1 = new PaymentInCard(null, 60.00, StatusPayment.Approved, srv2, 6);
		srv2.setPayment(pgt1);
		
		Payment pgt2 = new PaymentInMoney(null, 250.00, StatusPayment.Pending, srv1, simpleDateFormat.parse("02/09/2021 00:00"), null);
		srv1.setPayment(pgt2);
		
		Payment pgt3 = new PaymentInMoney(null, 75.00, StatusPayment.Approved, srv3, simpleDateFormat.parse("05/09/2021 16:30"), null);
		srv3.setPayment(pgt3);
		
		clt1.getServices().addAll(Arrays.asList(srv1, srv2));
		func1.getServices().addAll(Arrays.asList(srv1, srv2));
		
		srv2.getProducts().addAll(Arrays.asList(p1, p2, p4));
		srv3.getProducts().addAll(Arrays.asList(p3));
		
		serviceRepository.saveAll(Arrays.asList(srv1, srv2, srv3));
		paymentRepository.saveAll(Arrays.asList(pgt1, pgt2, pgt3));
	}
}
