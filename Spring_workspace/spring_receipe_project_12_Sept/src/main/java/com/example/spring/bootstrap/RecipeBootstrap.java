package com.example.spring.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.spring.model.Ingredient;
import com.example.spring.model.Note;
import com.example.spring.model.Recipe;
import com.example.spring.repo.IngredientRepo;
import com.example.spring.repo.NoteRepo;
import com.example.spring.repo.RecipeRepo;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private RecipeRepo rr;
	private IngredientRepo ir;
	private NoteRepo nr;
	
	
	
	public RecipeBootstrap(RecipeRepo rr, IngredientRepo ir, NoteRepo nr) {
		super();
		this.rr = rr;
		this.ir = ir;
		this.nr = nr;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
		
	}
	
	public void init() {
		Recipe r=new Recipe("20 min", "easy", "Chilli paneer", "how to do", "19 min", "4 people", "cooking Passion");
		String ing[]= {"this is ingredient1","this is ingredient2"};
		Ingredient i=new Ingredient("45 kile", ing);
		Note n=new Note("thsi is notr", "note is imp");
		
		r.setIngred(i);
		i.setRecipe(r);
		r.setNote(n);
		n.setRecipe(r);
		rr.save(r);
		ir.save(i);
		nr.save(n);
		
		Recipe r1=new Recipe("29 min", "difficult", "Chilli patato", "how to do", "9 min", "2 people", "cookingislovePassion");
		String ing1[]= {"this is ingredient1","this is ingredient3"};
		Ingredient i1=new Ingredient("4 kile", ing1);
		Note n1=new Note("thsi is not3 of chili", "note is imp");
		r1.setIngred(i1);
		i1.setRecipe(r1);
		r1.setNote(n1);
		n1.setRecipe(r1);
		rr.save(r1);
		ir.save(i1);
		nr.save(n1);
	}

}
