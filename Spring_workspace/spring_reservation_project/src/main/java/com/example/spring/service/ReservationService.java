package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import com.example.spring.model.Flight;
import com.example.spring.model.Passenger;

public interface ReservationService {

	//flight functions
	public List<Flight> findAllFlights();
	public Flight findFlightById(Long id);
	public void saveFlight(Flight flight);
	public void deleteFlight(Long id);
	
//passenger functions
	public List<Passenger> findAllPassenger();
	public Passenger findPassengerById(Long id);
	public void saveFlight(Passenger passenger);
	public void deletePassenger(Long id);
}
