package com.project.FlightBackendService;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FlightModel {
	@Id
	private Integer flightNo=0;
	private String flightName;
	private String source;
	private String destination;
	private String departure;
	private String arrival;
	private String flightCatg;
	private Integer amount;
	private String[] availDays;
	
	public FlightModel() {};
	
	public FlightModel(Integer flightNo, String flightName, String source, String destination, String departure,
			String arrival, String flightCatg, String[] availDays, Integer amount) {
		super();
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.flightCatg = flightCatg;
		this.availDays = availDays;
		this.amount = amount;
	}
	

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String[] getAvailDays() {
		return availDays;
	}

	public void setAvailDays(String[] availDays) {
		this.availDays = availDays;
	}

	public Integer getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(Integer flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getFlightCatg() {
		return flightCatg;
	}

	public void setFlightCatg(String flightCatg) {
		this.flightCatg = flightCatg;
	}

}
