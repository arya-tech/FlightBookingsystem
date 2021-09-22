package com.skylift.fbs.request;

import com.skylift.fbs.dto.PassengerDto;
import com.skylift.fbs.dto.PaymentDto;

import lombok.Data;

@Data
public class BookFlight {
	
	private PassengerDto passengerDto;
	
	private PaymentDto paymentDto;

}
