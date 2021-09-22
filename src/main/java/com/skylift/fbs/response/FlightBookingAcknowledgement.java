package com.skylift.fbs.response;

import java.util.Date;

import lombok.Data;

@Data
public class FlightBookingAcknowledgement {
	
	private String custName;
	private Date journeyDate;
	private double journeyFair;
	private String source;
	private String destination;
	private String custEmail;
	private String custMobile;

}
