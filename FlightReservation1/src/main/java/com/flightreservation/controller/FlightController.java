package com.flightreservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entities.Flight;
import com.flightreservation.service.FlightService;

@Controller
public class FlightController {

	@Autowired
	FlightService flightService;

	@RequestMapping("/showAllFlights")
	public String showAllFlights(ModelMap modelMap) {
		modelMap.addAttribute("flightList", flightService.showAllFlights());
		return "showFlights";
	}

	@RequestMapping("/showFlight")
	public String showFlight(@RequestParam(value = "number", required = false) String number,
			@RequestParam(value = "from", required = false) String from,
			@RequestParam(value = "to", required = false) String to,
			@RequestParam(value="depDate", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date depDate, ModelMap model) {
		if(from !=null || to!=null || depDate!= null) {
			List<Flight> flights = flightService.findFlightGeneric(from, to, depDate);
			model.addAttribute("flightList", flights);
			return "showFlights";
		}
		if(number !=null) {
		Long id = Long.valueOf(number);
		Optional<Flight> flights = flightService.findFlight(id);
		model.addAttribute("flight", flights.get());
		}
		return "showFlight";

	}
}
