package com.practiceproject.webshop.repointerface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiceproject.webshop.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
