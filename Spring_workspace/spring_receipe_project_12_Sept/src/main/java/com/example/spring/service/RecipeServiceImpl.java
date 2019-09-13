package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Ingredient;
import com.example.spring.model.Note;
import com.example.spring.model.Recipe;
import com.example.spring.repo.IngredientRepo;
import com.example.spring.repo.NoteRepo;
import com.example.spring.repo.RecipeRepo;

@Service
public class RecipeServiceImpl implements RecipeService {

	private RecipeRepo recipeRepo;
	private IngredientRepo ingredientRepo;
	private NoteRepo noteRepo;
	
	@Autowired
	public RecipeServiceImpl(RecipeRepo recipeRepo, IngredientRepo ingredientRepo, NoteRepo noteRepo) {
		super();
		this.recipeRepo = recipeRepo;
		this.ingredientRepo = ingredientRepo;
		this.noteRepo = noteRepo;
	}

	@Override
	public List<Recipe> getAllRecipe() {
		List<Recipe> recipe=recipeRepo.findAll();
		return recipe;
	}

	@Override
	public List<Note> getAllNote() {
		List<Note> note=noteRepo.findAll();
		return note;
	}

	@Override
	public List<Ingredient> getAllIngred() {
		List<Ingredient> ingred=ingredientRepo.findAll();
		return ingred;
	}

	@Override
	public Recipe getRecipeById(Integer id) {
		Recipe r=new Recipe();
		Optional<Recipe> result= recipeRepo.findById(id);
		if(result.isPresent()) {
			r=result.get();
		}else {
			throw new RuntimeException("result is not present");
		}
		return r;
	}

	@Override
	public Note getNoteById(Integer id) {
		Note r=new Note();
		Optional<Note> result= noteRepo.findById(id);
		if(result.isPresent()) {
			r=result.get();
		}else {
			throw new RuntimeException("result is not present");
		}
		return r;
	}

	@Override
	public Ingredient getIngreById(Integer id) {
		Ingredient r=new Ingredient();
		Optional<Ingredient> result= ingredientRepo.findById(id);
		if(result.isPresent()) {
			r=result.get();
		}else {
			throw new RuntimeException("result is not present");
		}
		return r;
	}

	@Override
	public void deleteRecipe(Integer id) {
	   Recipe r=getRecipeById(id);
	   recipeRepo.delete(r);
		
	}

	@Override
	public void updateRecipe(Integer id) {
		
		
	}

}
