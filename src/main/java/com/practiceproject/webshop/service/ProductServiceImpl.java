package com.practiceproject.webshop.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practiceproject.webshop.entities.Product;
import com.practiceproject.webshop.repository.ProductRepo;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductRepo productRepo;

	public List<Product> getProducts() {
		return productRepo.getAllProducts();
	}

	public Product getProduct(int productId) {
		return productRepo.getProductById(productId);
	}

	public List<Product> getProductsByBrand(int brandId) {
		List<Product> productList = new ArrayList<Product>();

		List<Product> list = (List<Product>) productRepo.getAllProducts();

		for (Product p : list) {
			if (p.getBrandId() == brandId) {
				productList.add(p);
			}
		}

		return productList;
	}

	public Product saveProduct(Product product) {
		Timestamp dateTime = Timestamp.from(Instant.now());
		product.setAddTime(dateTime);
		product.setUpdatedTime(dateTime);

		return productRepo.saveProduct(product);
	}

	public ResponseEntity<Object> updateProduct(Product product, int productId) {
		Timestamp dateTime = Timestamp.from(Instant.now());
		product.setUpdatedTime(dateTime);
		return productRepo.updateProduct(product, productId);
	}

	public ResponseEntity<Object> deleteProduct(int productId) {
		return productRepo.deleteProduct(productId);
	}

}
