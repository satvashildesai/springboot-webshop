package com.practiceproject.webshop.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiceproject.webshop.entities.Brand;
import com.practiceproject.webshop.repository.BrandRepo;

@Service
public class BrandServiceImpl {

	@Autowired
	private BrandRepo brandRepo;

	public List<Brand> getAllBrands() {
		return brandRepo.getAllBrands();
	}

	public Brand getBrand(int brandId) {
		return brandRepo.getBrand(brandId);
	}

	public Brand addBrand(Brand brand) {
		Timestamp dateTime = Timestamp.from(Instant.now());
		brand.setAddTime(dateTime);
		brand.setUpdatedTime(dateTime);

		return brandRepo.addBrand(brand);
	}

	public Brand updateBrand(Brand brand, int brandId) {
		return brandRepo.updateBrand(brand, brandId);
	}

	public Brand deleteBrand(int brandId) {
		return brandRepo.deleteBrand(brandId);
	}

	public List<Brand> getBrandByCategory(int categoryId) {
		return brandRepo.getBrandByCategory(categoryId);
	}

}
