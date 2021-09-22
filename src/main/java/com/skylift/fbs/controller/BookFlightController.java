package com.skylift.fbs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skylift.fbs.request.BookFlight;
import com.skylift.fbs.response.FlightBookingAcknowledgement;
import com.skylift.fbs.service.PassengerService;

@RestController
@RequestMapping("/ticket")
public class BookFlightController {

	@Autowired
	private PassengerService passengerService;
	
	@PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlightBookingAcknowledgement> bookFlightTicket(@RequestBody BookFlight request){
		FlightBookingAcknowledgement bookFlight = passengerService.bookFlight(request);
		return new ResponseEntity<>(bookFlight, HttpStatus.OK);
	}
	
}
