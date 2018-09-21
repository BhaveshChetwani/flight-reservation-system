package com.flightreservation.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Flight extends ParentClass{

	private String flightNumber;
	private String operatingAirlines;
	private String depCity;
	private String arrCity;
	private Date departureDate;
	private Timestamp estimatedTime;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirlines() {
		return operatingAirlines;
	}

	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Timestamp getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Timestamp estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

}
