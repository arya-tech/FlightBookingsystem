package com.skylift.fbs.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	
	private String paymentId;
	private String status;
	private double amount;
	private Date paymentDate;
	private String paymentMode;
	private String transactionId;
	private int passengerId;
	private String accNo;
	

}
