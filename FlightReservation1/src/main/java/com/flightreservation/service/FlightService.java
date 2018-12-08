package com.flightreservation.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.flightreservation.entities.Flight;

public interface FlightService {

	Iterator<Flight> showAllFlights();
	
	Optional<Flight> findFlight(Long id);
	
	List<Flight> findFlightGeneric(String from, String to, Date depDate);
}
