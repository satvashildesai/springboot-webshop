package com.practiceproject.webshop.repointerface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiceproject.webshop.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
