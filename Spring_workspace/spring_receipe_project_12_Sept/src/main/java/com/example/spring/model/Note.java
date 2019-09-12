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
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String Note;
	private String desc;
	@OneToOne(mappedBy = "note",cascade = CascadeType.ALL)
	private Recipe recipe;
	
	public Note() {
		super();
	}

	public Note(String note, String desc) {
		super();
		Note = note;
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
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
		return "Note [id=" + id + ", Note=" + Note + ", desc=" + desc + ", recipe=" + recipe + "]";
	}
	
	
	
}
