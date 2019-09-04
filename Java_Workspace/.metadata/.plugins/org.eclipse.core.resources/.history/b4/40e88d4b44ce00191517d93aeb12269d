package com.ibm.fsd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="student")
@Data

public class Student {
	@Column(name="id")
	private int id;
	@Column(name="fname")
	private String fName;
	@Column(name="lname")
	private String lName;
	@Column(name="email")
	private String email;
	
	public Student() {
		super();
	}

	public Student(int id, String fName, String lName, String email) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}

	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + "]";
	}
	
	

}
