package com.example.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entity.Shopping;

public interface ShoppingRepo extends JpaRepository<Shopping, Integer> {

}
