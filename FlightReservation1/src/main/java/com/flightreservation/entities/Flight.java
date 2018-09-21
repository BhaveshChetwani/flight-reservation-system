package com.flightreservation.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight{

	@Id
	private Long id;
	@Column(name = "flight_number")
	private String flightNumber;
	@Column(name = "operating_airlines")
	private String operatingAirlines;
	@Column(name = "departure_city")
	private String depCity;
	@Column(name = "arrival_city")
	private String arrCity;
	@Column(name = "date_of_departure")
	private Date dateOfDeparture;
	@Column(name = "estimated_departure_time")
	private Timestamp estDepTime;

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

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Timestamp getEstDepTime() {
		return estDepTime;
	}

	public void setEstDepTime(Timestamp estDepTime) {
		this.estDepTime = estDepTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
