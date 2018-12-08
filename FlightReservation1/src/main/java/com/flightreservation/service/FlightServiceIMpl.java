package com.flightreservation.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.entities.Flight;
import com.flightreservation.repos.FlightRepo;
import com.flightreservation.utility.HelperUtil;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepo flightRepo;

	@Override
	public Iterator<Flight> showAllFlights() {
		return flightRepo.findAll().iterator();
	}

	@Override
	public Optional<Flight> findFlight(Long id) {
		return flightRepo.findById(id);
	}

	@Override
	public List<Flight> findFlightGeneric(String from, String to, Date depDate) {
		if (HelperUtil.notNull(from) 
				|| HelperUtil.notNull(to) 
				|| HelperUtil.notNull(depDate)) {
			if (HelperUtil.notNull(from)) {
				if (HelperUtil.notNull(to) 
						&& HelperUtil.notNull(depDate)) {
					java.sql.Date sqlDate = new java.sql.Date(depDate.getTime());
					return flightRepo.findFlightByQuery(from, to, sqlDate);
				} else if (HelperUtil.notNull(to)) {
					return flightRepo.findFlightFromTo(from, to);
				} else if (HelperUtil.notNull(depDate)) {
					java.sql.Date sqlDate = new java.sql.Date(depDate.getTime());
					return flightRepo.findFlightFromDepDate(from, sqlDate);
				} else {
					return flightRepo.findFlightFrom(from);
				}
			} else {
				if (HelperUtil.notNull(to) 
						&& HelperUtil.notNull(depDate)) {
					java.sql.Date sqlDate = new java.sql.Date(depDate.getTime());
					return flightRepo.findFlightToDepDate(to, sqlDate);
				} else if (HelperUtil.notNull(to)) {
					return flightRepo.findFlightTo(to);
				} else if (HelperUtil.notNull(depDate)) {
					java.sql.Date sqlDate = new java.sql.Date(depDate.getTime());
					return flightRepo.findFlightDepDate(sqlDate);
				}

			}
		}
		return null;
	}

}