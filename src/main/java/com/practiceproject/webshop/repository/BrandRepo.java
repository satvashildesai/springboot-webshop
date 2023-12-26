package com.practiceproject.webshop.repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practiceproject.webshop.entities.Brand;
import com.practiceproject.webshop.repointerface.BrandRepository;

@Repository
public class BrandRepo {
	@Autowired
	BrandRepository brandRepo;

	public List<Brand> getAllBrands() {
		return brandRepo.findAll();
	}

	public Brand getBrand(int brandId) {
		return brandRepo.findById(brandId).get();
	}

	public Brand addBrand(Brand brand) {
		return brandRepo.save(brand);
	}

	public Brand updateBrand(Brand brand, int brandId) {
		Optional<Brand> brandOptional = brandRepo.findById(brandId);

		if (brandOptional.isEmpty())
			return null;

		Brand dbBrand = brandOptional.get();
		Timestamp dateTime = Timestamp.from(Instant.now());
		brand.setBrandId(brandId);
		brand.setUpdatedTime(dateTime);
		brand.setAddTime(dbBrand.getAddTime());

		brandRepo.save(brand);

		return brand;
	}

	public Brand deleteBrand(int brandId) {
		Optional<Brand> brandOptional = brandRepo.findById(brandId);

		if (brandOptional.isEmpty())
			return null;

		Brand dbBrand = brandOptional.get();
		brandRepo.deleteById(brandId);

		return dbBrand;
	}

	public List<Brand> getBrandByCategory(int categoryId) {
		List<Brand> dbBrandList = brandRepo.findAll();
		List<Brand> brandList = new ArrayList<Brand>();

		for (Brand b : dbBrandList) {
			if (b.getCategoryId() == categoryId) {
				brandList.add(b);
			}
		}

		return brandList;
	}

}
