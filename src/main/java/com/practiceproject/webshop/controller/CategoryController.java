package com.practiceproject.webshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practiceproject.webshop.entities.Category;
import com.practiceproject.webshop.service.CategoryServiceImpl;

@RestController
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryService;

//	Get all Categories
	@GetMapping("/category")
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

//	Get category by id
	@GetMapping("/category/{categoryId}")
	public Category getCategory(@PathVariable String categoryId) {
		return categoryService.getCategory(Integer.parseInt(categoryId));
	}

//	Save/post category
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

//	Update/put category
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/category/{categoryId}")
	public Category updateCategory(@RequestBody Category category, @PathVariable String categoryId) {
		return categoryService.updateCategory(category, Integer.parseInt(categoryId));
	}

//	Delete category
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/category/{categoryId}")
	public Category deleteCategory(@PathVariable String categoryId) {
		return categoryService.deleteCategory(Integer.parseInt(categoryId));
	}
}

//Get all categories
//Get category by category id
//Post category
//Put category
//Delete category
