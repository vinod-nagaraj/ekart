package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Optional<List<Product>> findByProductId(String productName, Double price);
	Optional<List<Product>> findByProductId();
	
	
	

}
