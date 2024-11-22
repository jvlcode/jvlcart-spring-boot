package com.jvlcode.jvlcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jvlcode.jvlcart.models.Product;
import com.jvlcode.jvlcart.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	

	 // Method to search products by keyword in name or description
    public Page<Product> searchProducts(String keyword, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword, pageable);
    }

    // Method to fetch all products with pagination
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
