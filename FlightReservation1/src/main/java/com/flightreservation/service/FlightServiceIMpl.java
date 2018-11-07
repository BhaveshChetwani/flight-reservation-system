package com.flightreservation.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.entities.Flight;
import com.flightreservation.repos.FlightRepo;

@Service
public class FlightServiceIMpl implements FlightService {

	@Autowired
	FlightRepo flightRepo;

	@Override
	public Iterator<Flight> showAllFlights() {
		return flightRepo.findAll().iterator();
	}

}
