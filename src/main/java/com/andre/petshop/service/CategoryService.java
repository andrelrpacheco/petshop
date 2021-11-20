package com.andre.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.petshop.domain.Category;
import com.andre.petshop.repository.CategoryRepository;
import com.andre.petshop.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category findCategoryId(Integer id) {
		Optional<Category> categoryId = repository.findById(id);
		return categoryId.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. ID: " + id + ", Tipo: " + Category.class.getName()));
	}
}
