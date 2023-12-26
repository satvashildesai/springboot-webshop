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

import com.practiceproject.webshop.entities.Brand;
import com.practiceproject.webshop.service.BrandServiceImpl;

@RestController
public class BrandController {
	@Autowired
	private BrandServiceImpl brandService;

//	Get all brands
	@GetMapping("/brands")
	public List<Brand> getAllBrands() {

		return this.brandService.getAllBrands();
	}

//	Get brand by id
	@GetMapping("/brands/{brandId}")
	public Brand getBrand(@PathVariable String brandId) {
		return brandService.getBrand(Integer.parseInt(brandId));
	}

//	Get brand by category
	@GetMapping("/brands/category/{categoryId}")
	public List<Brand> getBrandByCategory(@PathVariable String categoryId) {
		return brandService.getBrandByCategory(Integer.parseInt(categoryId));
	}

//	Save/post brand
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/brands")
	public Brand addBrand(@RequestBody Brand brand) {
		System.out.println(brand);
		return brandService.addBrand(brand);
	}

//	Update/put brand
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/brands/{brandId}")
	public Brand updateBrand(@RequestBody Brand brand, @PathVariable String brandId) {
		return brandService.updateBrand(brand, Integer.parseInt(brandId));
	}

//	Delete brand
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/brands/{brandId}")
	public Brand deleteBrand(@PathVariable String brandId) {
		return brandService.deleteBrand(Integer.parseInt(brandId));
	}
}

// Get all brands
// Get brand by brand id
// Get brand by category
// Post brand
// Put brand
// Delete brand
