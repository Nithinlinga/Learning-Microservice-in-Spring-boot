package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByAuthId(int authId);

	
}
