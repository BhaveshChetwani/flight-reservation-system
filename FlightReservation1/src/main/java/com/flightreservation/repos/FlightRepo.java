package com.flightreservation.repos;

import org.springframework.data.repository.CrudRepository;

import com.flightreservation.entities.Flight;

public interface FlightRepo extends CrudRepository<Flight, Long> {

}
