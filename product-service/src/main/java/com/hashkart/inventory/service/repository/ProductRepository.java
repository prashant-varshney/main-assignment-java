package com.hashkart.inventory.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hashkart.inventory.service.model.Category;
import com.hashkart.inventory.service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findAllByCategory(Category category);

	List<Product> findAllByNameContainingIgnoreCase(String productName);

}
