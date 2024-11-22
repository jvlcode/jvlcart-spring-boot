package com.jvlcode.jvlcart.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jvlcode.jvlcart.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	 // Custom query method for searching by name and description using LIKE
    Page<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String nameKeyword, String descriptionKeyword, Pageable pageable);
}
