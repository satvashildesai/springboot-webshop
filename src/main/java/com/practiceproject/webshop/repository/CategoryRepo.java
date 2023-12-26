package com.practiceproject.webshop.repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practiceproject.webshop.entities.Category;
import com.practiceproject.webshop.repointerface.CategoryRepository;

@Repository
public class CategoryRepo {

	@Autowired
	CategoryRepository categoryRepo;

	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	public Category getCategory(int categoryId) {
		return categoryRepo.findById(categoryId).get();
	}

	public Category updateCategory(Category category, int categoryId) {
		Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
		if (categoryOptional.isEmpty())
			return null;

		Category dbCategory = categoryOptional.get();
		category.setCategoryId(categoryId);
		category.setAddTime(dbCategory.getAddTime());
		category.setUpdatedTime(Timestamp.from(Instant.now()));

		categoryRepo.save(category);

		return category;
	}

	public Category deleteCategory(int categoryId) {
		categoryRepo.deleteById(categoryId);
		return null;
	}

}
