package com.jvlcode.jvlcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jvlcode.jvlcart.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
