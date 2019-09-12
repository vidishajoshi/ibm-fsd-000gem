package com.example.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Ingredient;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {

}
