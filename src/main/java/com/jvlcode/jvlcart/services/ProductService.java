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
	
	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
}
