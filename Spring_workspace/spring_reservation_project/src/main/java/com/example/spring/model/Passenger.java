package com.example.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fname;
	private String lname;
	private String email;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="reservation",joinColumns = @JoinColumn(name="passenger_id"),
	inverseJoinColumns = @JoinColumn(name="flight_id"))
	private Set<Flight> flight=new HashSet<>();

	public Passenger() {
		super();
	}

	public Passenger(String fname, String lname, String email,Set<Flight> flight) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.flight = flight;
	}

	public Passenger(String fname, String lname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Set<Flight> getFlight() {
		return flight;
	}

	public void setFlight(Set<Flight> flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email +  ", flight=" + flight + "]";
	}
	
	
	
	
	
	
}
