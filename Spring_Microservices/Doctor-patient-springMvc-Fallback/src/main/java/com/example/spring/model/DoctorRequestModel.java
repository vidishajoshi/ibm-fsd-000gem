package com.example.spring.model;

public class DoctorRequestModel {

	private Integer id;
	private String name;
	private String special;
	public DoctorRequestModel() {
		super();
	}
	public DoctorRequestModel(String name, String special) {
		super();
		this.name = name;
		this.special = special;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	
	
}
