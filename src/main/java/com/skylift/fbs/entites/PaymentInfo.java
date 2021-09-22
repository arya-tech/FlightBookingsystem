package com.skylift.fbs.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payment")
public class PaymentInfo {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "pay_id")
	private String paymentId;
	private String status;
	private double amount;
	@Column(name = "pay_dt")
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date paymentDate;
	@Column(name = "pay_mode")
	private String paymentMode;
	@Column(name = "tx_id")
	private String transactionId;
	@Column(name="pid")
	private int passengerId;
	@Column(name = "acc_no")
	private String accNo;
	

}
