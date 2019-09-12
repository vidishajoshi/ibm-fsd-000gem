package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.Reprository.FlightRepro;
import com.example.spring.Reprository.PassengerRepo;
import com.example.spring.model.Flight;
import com.example.spring.model.Passenger;

@Service
public class ReservationServiceImpl implements ReservationService {

	
	private FlightRepro flightRepro;
   
	private PassengerRepo passengerRepo;
	
	
	@Autowired
	public ReservationServiceImpl(FlightRepro flightRepro, PassengerRepo passengerRepo) {
		super();
		this.flightRepro = flightRepro;
		this.passengerRepo = passengerRepo;
	}

	@Override
	public List<Flight> findAllFlights() {
		
		List<Flight> list= flightRepro.findAll();
		return list;
	}

	@Override
	public Flight findFlightById(Long id) {
		Optional<Flight> result= flightRepro.findById(id);
		Flight f=null;
		if(result.isPresent()) {
			f=result.get();
		}else {
			throw new RuntimeException("result is emty");
		}
		return f;
	}

	@Override
	public void saveFlight(Flight flight) {
		flightRepro.save(flight);

	}

	@Override
	public void deleteFlight(Long id) {
		flightRepro.deleteById(id);

	}

	@Override
	public List<Passenger> findAllPassenger() {
		
		return passengerRepo.findAll();
	}

	@Override
	public Passenger findPassengerById(Long id) {
		Optional<Passenger> result=passengerRepo.findById(id);
		Passenger p=null;
		if(result.isPresent()) {
			p=result.get();
		}else {
			throw new RuntimeException("result is not present");
		}
		return p;
	}

	@Override
	public void saveFlight(Passenger passenger) {
		passengerRepo.save(passenger);

	}

	@Override
	public void deletePassenger(Long id) {
		passengerRepo.deleteById(id);

	}

	@Override
	public void editPassenger(Long id) {
		
		
	}

	@Override
	public void editFlight(Long id) {
		
		
	}
}
