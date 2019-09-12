package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.model.Ingredient;
import com.example.spring.model.Note;
import com.example.spring.model.Recipe;
import com.example.spring.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class HomeController {

	@Autowired
	private RecipeService rs;
	
	@RequestMapping("/display")
	public String goHome(Model theModel) {
		List<Recipe> list=rs.getAllRecipe();
		theModel.addAttribute("receipe",list);
		return "receipe/home";
	}
	
	@RequestMapping("/showRecipes")
	public String viewRecipes(@RequestParam("id") Integer id,Model theModel) {
		
		Recipe r=rs.getRecipeById(id);
		Ingredient i=r.getIngred();
		Note n=r.getNote();
		theModel.addAttribute("recipe",r);
		theModel.addAttribute("ingre",i);
		theModel.addAttribute("note",n);
		return "receipe/view";
	}
	
	@RequestMapping("/delete")
	public String deleteRecipe(@RequestParam("id") Integer id) {
		rs.deleteRecipe(id);
		return "redirect:/recipe/display";
	}
}
