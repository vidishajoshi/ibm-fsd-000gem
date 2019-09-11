package com.example.spring.Reprository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Passenger;
@Repository
public interface PassengerRepo extends CrudRepository<Passenger, Long> {

}
