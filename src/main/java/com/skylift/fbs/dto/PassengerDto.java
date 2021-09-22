package com.skylift.fbs.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {
	
	private int passengerId;
	private String passengerName;
	private String email;
	private String mobileNo;
	private int age;
	private String addLine1;
	private String city;
	private String state;
	private String country;
	private int zip;
	private Date ticketBookDate;
	private String uniqueId;
	private String source;
	private String destination;
	private Date travelDate;

}
