package com.flightreservation.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.flightreservation.entities.Flight;

@Component
public interface FlightRepo extends CrudRepository<Flight, Long> {

	@Query("from Flight where depCity=:from and arrCity=:to and dateOfDeparture=:depDate")
	public List<Flight> findFlightByQuery(@Param("from")String from, @Param("to")String to,@Param("depDate") Date depDate);
	
	@Query("from Flight where depCity=:from and arrCity=:to")
	public List<Flight> findFlightFromTo(@Param("from")String from, @Param("to")String to);
	
	@Query("from Flight where depCity=:from and dateOfDeparture=:depDate")
	public List<Flight> findFlightFromDepDate(@Param("from")String from, @Param("depDate") Date depDate);
	
	@Query("from Flight where depCity=:from")
	public List<Flight> findFlightFrom(@Param("from")String from);
	
	@Query("from Flight where dateOfDeparture=:depDate")
	public List<Flight> findFlightDepDate(@Param("depDate") Date depDate);
	
	@Query("from Flight where arrCity=:to")
	public List<Flight> findFlightTo(@Param("to") String to);
	
	@Query("from Flight where arrCity=:to and dateOfDeparture=:depDate")
	public List<Flight> findFlightToDepDate(@Param("to") String to, @Param("depDate") java.sql.Date sqlDate);
	
}
