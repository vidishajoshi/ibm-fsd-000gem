package com.example.spring.model;

public class PatientRequestModel {


	private Integer id;
	private String name;
	private String disease;

	
	

	public PatientRequestModel() {
		super();
	}
	public PatientRequestModel(String pName, String disease) {
		super();
		this.name = pName;
		this.disease = disease;
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
	public void setName(String pName) {
		this.name = pName;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	

}
