package com.practiceproject.webshop.repointerface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiceproject.webshop.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
