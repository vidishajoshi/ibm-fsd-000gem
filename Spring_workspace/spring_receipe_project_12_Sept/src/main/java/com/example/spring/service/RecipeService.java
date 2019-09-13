package com.example.spring.service;

import java.util.List;

import com.example.spring.model.Ingredient;
import com.example.spring.model.Note;
import com.example.spring.model.Recipe;

public interface RecipeService {

	//recipe function
	public List<Recipe> getAllRecipe();
	public Recipe getRecipeById(Integer id);
	public void deleteRecipe(Integer id);
	public void updateRecipe(Integer id);
	
	//note function
	public List<Note> getAllNote();
	public Note getNoteById(Integer id);
	
	//ingredient function
	public List<Ingredient> getAllIngred();
	public Ingredient getIngreById(Integer id);
}
