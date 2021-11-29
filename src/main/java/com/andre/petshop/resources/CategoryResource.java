package com.andre.petshop.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.petshop.domain.Category;
import com.andre.petshop.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	CategoryService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCategories(@PathVariable Integer id) {
		Category categoryData = service.findCategoryId(id);
		
		return ResponseEntity.ok().body(categoryData);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createCategory(@RequestBody Category data) {
		
		data = service.createCategory(data);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCategory(@RequestBody Category data, @PathVariable Integer id) {
		
		data.setId(id);
		data = service.updateCategory(data);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeCategory(@PathVariable Integer id) {
		service.removeCategory(id);
		return ResponseEntity.noContent().build();
	}
}
