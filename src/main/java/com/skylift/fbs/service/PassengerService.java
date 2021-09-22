package com.skylift.fbs.service;

import com.skylift.fbs.request.BookFlight;
import com.skylift.fbs.response.FlightBookingAcknowledgement;

public interface PassengerService {

	public FlightBookingAcknowledgement bookFlight(BookFlight bookFlight);
}
