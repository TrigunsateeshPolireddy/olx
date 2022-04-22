package com.zensar.olxmaster.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmaster.entity.Category;

@RestController
public class MyControllerCategory {
	static List<Category> category = new ArrayList<Category>();
	
	static {
		category.add(new Category(1, "Furniture"));
		category.add(new Category(2, "RealEstate"));
		category.add(new Category(3, "Cars"));
		category.add(new Category(4, "Mobiles"));
		category.add(new Category(5, "Sports"));
		
	}
	@GetMapping("/advertise/category")
	public List<Category> getAllCategory() {
		return category;
	}

}
