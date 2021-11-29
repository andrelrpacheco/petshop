package com.andre.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.andre.petshop.domain.Category;
import com.andre.petshop.repository.CategoryRepository;
import com.andre.petshop.service.exceptions.DataIntegrityException;
import com.andre.petshop.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository accessRepository;
	
	public Category findCategoryId(Integer id) {
		Optional<Category> categoryId = accessRepository.findById(id);
		return categoryId.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
	}
	
	public Category createCategory(Category data) {
		data.setId(null);
		return accessRepository.save(data);
	}
	
	public Category updateCategory(Category data) {
		findCategoryId(data.getId());
		return accessRepository.save(data);
	}
	
	public void removeCategory(Integer id) {
		findCategoryId(id);
		try {
			accessRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Categoria possui produto, não é possível deletar!");
		}
	}
}
