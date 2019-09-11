package com.example.spring.Reprository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Flight;
@Repository
public interface FlightRepro extends CrudRepository<Flight, Long> {

}
