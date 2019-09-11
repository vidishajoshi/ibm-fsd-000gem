package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.model.Flight;
import com.example.spring.model.Passenger;
import com.example.spring.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class HomeController {
	@Autowired
	private ReservationService rs;
	
	@GetMapping("/view")
	public String listReservation(Model theModel) {
		List<Flight> fl=rs.findAllFlights();
		List<Passenger> pl=rs.findAllPassenger();
		theModel.addAttribute("flight", fl);
		theModel.addAttribute("passenger", pl);
		return "reservation/list_reservation";
		
	}
	
	@GetMapping("/showFormForAddFlight")
	public String addFlightDetails(Model theModel) {
		Flight flight=new Flight();
		theModel.addAttribute("flight",flight);
		return "reservation/addFlights";
		
	}
	
	@GetMapping("/showFormForAddPassenger")
	public String addPassengerDetails(Model theModel) {
		Passenger passenger=new Passenger();
		theModel.addAttribute("passenger", passenger);
		return "reservation/addPassenger";
		
	}
	

	@PostMapping("/flight/save")
	public String saveFlight(@ModelAttribute("flight") Flight theFlight) {
		rs.saveFlight(theFlight);
		return "redirect:/reservation/view";
		
	}
	

	@PostMapping("/passenger/save")
	public String savePassenger(@ModelAttribute("passenger") Passenger thePassenger) {
		rs.saveFlight(thePassenger);
		return "redirect:/reservation/view";

}
}