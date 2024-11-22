package com.jvlcode.jvlcart.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jvlcode.jvlcart.models.Product;
import com.jvlcode.jvlcart.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Map<String, Object> getAllProducts(@RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "3") int size,  
		 	@RequestParam(required = false) String keyword) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> productPage;

        // If a keyword is provided, search the products, otherwise get all
        if (keyword != null && !keyword.isEmpty()) {
            productPage = productService.searchProducts(keyword, pageable);
        } else {
            productPage = productService.getAllProducts(pageable);
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("count", productPage.getTotalElements());
        response.put("resPerPage", size);
        response.put("products", productPage.getContent());
        return response;
	}
	
	@GetMapping("/category")
	public List<Map<String,Object>> getCategoryProducts() {
		return Arrays.asList(
				Map.of("name", "Product 1", "price", 234),
				Map.of("name", "Product 2", "price", 123)
			);
	}
	
}
