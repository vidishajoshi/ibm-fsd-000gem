package com.example.spring.Reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.spring.model.Flight;
@Repository
public interface FlightRepro extends JpaRepository<Flight, Long> {

}
