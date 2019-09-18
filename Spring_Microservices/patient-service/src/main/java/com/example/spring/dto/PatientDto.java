package com.example.spring.dto;

public class PatientDto {


	private Integer id;
	private String name;
	private String disease;
	
	
	
	public PatientDto() {
		super();
	}
	public PatientDto(String pName, String disease) {
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
