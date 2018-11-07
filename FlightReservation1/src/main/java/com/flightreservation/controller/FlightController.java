package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
