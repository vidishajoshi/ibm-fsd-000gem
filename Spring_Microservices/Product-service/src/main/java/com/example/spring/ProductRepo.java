package com.example.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	public Product findByProductName(String pname);
	public Product findByProductType(String ptype);

}
