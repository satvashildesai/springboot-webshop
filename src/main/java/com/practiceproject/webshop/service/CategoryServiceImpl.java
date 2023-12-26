package com.practiceproject.webshop.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiceproject.webshop.entities.Category;
import com.practiceproject.webshop.repository.CategoryRepo;

@Service
public class CategoryServiceImpl {

	@Autowired
	private CategoryRepo categoryRepo;

	public List<Category> getAllCategory() {
		return categoryRepo.getAllCategory();
	}

	public Category getCategory(int categoryId) {
		return categoryRepo.getCategory(categoryId);
	}

	public Category addCategory(Category category) {
		Timestamp dateTime = Timestamp.from(Instant.now());
		category.setAddTime(dateTime);
		category.setUpdatedTime(dateTime);

		return categoryRepo.addCategory(category);
	}

	public Category updateCategory(Category category, int categoryId) {
		return categoryRepo.updateCategory(category, categoryId);
	}

	public Category deleteCategory(int categoryId) {
		return categoryRepo.deleteCategory(categoryId);
	}

}
