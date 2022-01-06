package com.learning.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.poc.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
