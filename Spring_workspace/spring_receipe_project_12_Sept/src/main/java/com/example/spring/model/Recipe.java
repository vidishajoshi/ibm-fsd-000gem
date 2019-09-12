package com.example.spring.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String cookTime;
	private String difficulty;
	private String Name;
	private String direction;
	private String prepTime;
	private String serve;
	private String source;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="note_id")
	private Note note;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ingred_id")
	private Ingredient ingred;

	public Recipe() {
		super();
	}

	

	public Recipe(String cookTime, String difficulty, String name, String direction, String prepTime, String serve,
			String source) {
		super();
		this.cookTime = cookTime;
		this.difficulty = difficulty;
		Name = name;
		this.direction = direction;
		this.prepTime = prepTime;
		this.serve = serve;
		this.source = source;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getServe() {
		return serve;
	}

	public void setServe(String serve) {
		this.serve = serve;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Ingredient getIngred() {
		return ingred;
	}

	public void setIngred(Ingredient ingred) {
		this.ingred = ingred;
	}

	
	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	@Override
	public String toString() {
		return "Recipe [id=" + id + ", cookTime=" + cookTime + ", difficulty=" + difficulty + ", Name=" + Name
				+ ", direction=" + direction + ", prepTime=" + prepTime + ", serve=" + serve + ", source=" + source
				+ ", note=" + note + ", ingred=" + ingred + "]";
	}



	
	
	
	
	
	
	

}
