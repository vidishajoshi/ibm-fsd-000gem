package com.example.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {

}
