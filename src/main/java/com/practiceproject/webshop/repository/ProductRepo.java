package com.practiceproject.webshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.practiceproject.webshop.entities.Product;
import com.practiceproject.webshop.repointerface.ProductRepository;

@Repository
public class ProductRepo {
	@Autowired
	private ProductRepository productRepo;

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(int productId) {
		return productRepo.findById(productId).get();
	}

	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	public ResponseEntity<Object> updateProduct(Product product, int productId) {
		Optional<Product> productOptional = productRepo.findById(productId);

		if (productOptional.isEmpty())
			return ResponseEntity.notFound().build();

		Product dbProduct = productOptional.get();

		product.setProductId(productId);
		product.setAddTime(dbProduct.getAddTime());
		productRepo.save(product);

		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Object> deleteProduct(int productId) {
		Optional<Product> productOptional = productRepo.findById(productId);

		if (productOptional.isEmpty())
			return ResponseEntity.notFound().build();

		productRepo.deleteById(productId);

		return null;
	}
}