package com.practiceproject.webshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practiceproject.webshop.entities.Product;
import com.practiceproject.webshop.service.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

//	Get all products
	@GetMapping("/products")
	public List<Product> getProducts() {
		return this.productService.getProducts();
	}

//	Get products by product id
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable String productId) {
		return productService.getProduct(Integer.parseInt(productId));
	}

//	Get products by the brand
	@GetMapping("/products/brands/{brandId}")
	public List<Product> getProductsByBrand(@PathVariable String brandId) {
		try {
			return this.productService.getProductsByBrand(Integer.parseInt(brandId));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

//	Save/Post product
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

//	Update/put product
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/products/{productId}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable String productId) {
		return productService.updateProduct(product, Integer.parseInt(productId));
	}

//	Delete product
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable String productId) {
		return productService.deleteProduct(Integer.parseInt(productId));
	}

}

//Get all products
//Get product by product id
//Get products by brand id
//Post product
//Put product
//Delete product
