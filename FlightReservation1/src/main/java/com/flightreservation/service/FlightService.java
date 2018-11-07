package com.flightreservation.service;

import java.util.Iterator;

import com.flightreservation.entities.Flight;

public interface FlightService {

	Iterator<Flight> showAllFlights();
}
