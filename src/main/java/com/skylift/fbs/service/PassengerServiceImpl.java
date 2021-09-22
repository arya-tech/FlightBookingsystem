package com.skylift.fbs.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylift.fbs.entites.PassengerInfo;
import com.skylift.fbs.entites.PaymentInfo;
import com.skylift.fbs.exception.InsufficiantAmountException;
import com.skylift.fbs.repository.PassengerInfoRepository;
import com.skylift.fbs.repository.PaymentInfoRepository;
import com.skylift.fbs.request.BookFlight;
import com.skylift.fbs.response.FlightBookingAcknowledgement;
import com.skylift.fbs.util.BookingAmtValidation;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	@Transactional
	public FlightBookingAcknowledgement bookFlight(BookFlight bookFlight) {
		PassengerInfo passengerInfo = new PassengerInfo();
		PaymentInfo paymentInfo = new PaymentInfo();
		FlightBookingAcknowledgement flightBookingAcknowledgement = new FlightBookingAcknowledgement();
		passengerInfo.setAddLine1(bookFlight.getPassengerDto().getAddLine1());
		passengerInfo.setAge(bookFlight.getPassengerDto().getAge());
		passengerInfo.setCity(bookFlight.getPassengerDto().getCity());
		passengerInfo.setCountry(bookFlight.getPassengerDto().getCountry());
		passengerInfo.setDestination(bookFlight.getPassengerDto().getDestination());
		passengerInfo.setEmail(bookFlight.getPassengerDto().getEmail());
		passengerInfo.setMobileNo(bookFlight.getPassengerDto().getMobileNo());
		passengerInfo.setPassengerName(bookFlight.getPassengerDto().getPassengerName());
		passengerInfo.setSource(bookFlight.getPassengerDto().getSource());
		passengerInfo.setState(bookFlight.getPassengerDto().getState());
		passengerInfo.setTicketBookDate(bookFlight.getPassengerDto().getTicketBookDate());
		passengerInfo.setUniqueId(bookFlight.getPassengerDto().getUniqueId());
		passengerInfo.setZip(bookFlight.getPassengerDto().getZip());
		
		PassengerInfo savedPassengerInfo = passengerInfoRepository.save(passengerInfo);
		
		if(BookingAmtValidation.validateTicketAmount(bookFlight.getPaymentDto().getAccNo(), bookFlight.getPaymentDto().getAmount())==false) {
			throw new InsufficiantAmountException("insufficient balance");
		} 
		paymentInfo.setAmount( bookFlight.getPaymentDto().getAmount());
		paymentInfo.setPassengerId(savedPassengerInfo.getPassengerId());
		paymentInfo.setPaymentDate(savedPassengerInfo.getTicketBookDate());
		paymentInfo.setPaymentMode("debit");
		paymentInfo.setStatus("success");
		paymentInfo.setTransactionId(UUID.randomUUID().toString());
		
		PaymentInfo savedPaymentInfo = paymentInfoRepository.save(paymentInfo);
		
		flightBookingAcknowledgement.setCustEmail(savedPassengerInfo.getEmail());
		flightBookingAcknowledgement.setCustMobile(savedPassengerInfo.getMobileNo());
		flightBookingAcknowledgement.setCustName(savedPassengerInfo.getPassengerName());
		flightBookingAcknowledgement.setDestination(savedPassengerInfo.getDestination());
		flightBookingAcknowledgement.setJourneyDate(savedPassengerInfo.getTicketBookDate());
		flightBookingAcknowledgement.setSource(savedPassengerInfo.getSource());
		flightBookingAcknowledgement.setJourneyFair(savedPaymentInfo.getAmount());
		return flightBookingAcknowledgement;
		
	}
	

}
