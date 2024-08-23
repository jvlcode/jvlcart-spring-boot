package com.jvlcode.jvlcart.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping
	public List<Map<String,Object>> getAllProducts() {
		return Arrays.asList(
				Map.of("name", "Product 1", "price", 234),
				Map.of("name", "Product 2", "price", 123)
			);
	}
	
	@GetMapping("/category")
	public List<Map<String,Object>> getCategoryProducts() {
		return Arrays.asList(
				Map.of("name", "Product 1", "price", 234),
				Map.of("name", "Product 2", "price", 123)
			);
	}
	
}
