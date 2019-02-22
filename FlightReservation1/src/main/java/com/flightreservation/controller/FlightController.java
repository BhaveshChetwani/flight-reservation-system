package com.flightreservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entities.Flight;
import com.flightreservation.entities.User;
import com.flightreservation.service.FlightService;
import com.flightreservation.utility.HelperUtil;

@Controller
public class FlightController {

	@Autowired
	FlightService flightService;

	@RequestMapping("/showAllFlights")
	public String showAllFlights(ModelMap modelMap, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(HelperUtil.notNull(user)) {
			System.out.println(user.getFirstName());
		}
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
			if(HelperUtil.notNull(flights)) {
				System.out.println(flights.get(0).getDateOfDeparture());
			}
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
	
	@RequestMapping("/bookFlight")
	public String bookFlight(@RequestParam("id") Long id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(HelperUtil.notNull(user)) {
			System.out.println("book my flight");
		}
		System.out.println("register the user again");
		return "registerUser";
	}
}
