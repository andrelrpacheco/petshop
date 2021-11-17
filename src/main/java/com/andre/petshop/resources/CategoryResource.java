package com.andre.petshop.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andre.petshop.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> getCategories() {
		
		Category foodCategory = new Category(1, "Alimento");
		Category cosmeticCategory = new Category(2, "Cosmético");
		Category medicineCategory = new Category(3, "Remédio");
		
		List<Category> listCategory = new ArrayList<>();
		
		listCategory.add(foodCategory);
		listCategory.add(cosmeticCategory);
		listCategory.add(medicineCategory);
		
		return listCategory;
	}
}
