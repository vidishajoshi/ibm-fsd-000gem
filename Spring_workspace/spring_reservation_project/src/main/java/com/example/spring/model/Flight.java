package com.example.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String flightName;
	private String source;
	private String dest;
	
	@ManyToMany(mappedBy="flight")
	private Set<Passenger> passenger=new HashSet<>();

	public Flight() {
		super();
	}

	public Flight(String flightName, String source, String dest) {
		super();
		this.flightName = flightName;
		this.source = source;
		this.dest = dest;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public Set<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(Set<Passenger> passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightName=" + flightName + ", source=" + source + ", dest=" + dest
				+ ", passenger=" + passenger + "]";
	}
	
	
	
}
