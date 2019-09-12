package com.example.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String Amount;
	private String desc[];
	@OneToOne(mappedBy = "ingred",cascade = CascadeType.ALL)
	private Recipe recipe;
	
	public Ingredient() {
		super();
	}

	

	public Ingredient(String amount, String[] desc) {
		super();
		Amount = amount;
		this.desc = desc;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}


	public String[] getDesc() {
		return desc;
	}



	public void setDesc(String[] desc) {
		this.desc = desc;
	}



	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", Amount=" + Amount + ", desc=" + desc + ", recipe=" + recipe + "]";
	}

	
	



}
