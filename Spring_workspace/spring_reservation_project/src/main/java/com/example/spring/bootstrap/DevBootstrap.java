package com.example.spring.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.spring.Reprository.FlightRepro;
import com.example.spring.Reprository.PassengerRepo;
import com.example.spring.model.Flight;
import com.example.spring.model.Passenger;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private PassengerRepo pr;
	private FlightRepro fr;
	
	
	public DevBootstrap(PassengerRepo pr, FlightRepro fr) {
		super();
		this.pr = pr;
		this.fr = fr;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		init();
	}

	private void init() {
		Passenger p= new Passenger("mark","john", "mark@g.com");
		Flight f=new Flight("GoAir","Bangalore", "Delhi");
		p.getFlight().add(f);
		f.getPassenger().add(p);
		pr.save(p);
		fr.save(f);
		
		
	}
}
