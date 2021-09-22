package com.skylift.fbs.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passenger")
public class PassengerInfo {
	
	@Id
	@GeneratedValue
	@Column(name = "pid")
	private int passengerId;
	@Column(name = "pass_name")
	private String passengerName;
	private String email;
	@Column(name = "mob_no")
	private String mobileNo;
	private int age;
	@Column(name = "add_line1")
	private String addLine1;
	private String city;
	private String state;
	private String country;
	private int zip;
	@Column(name = "ticket_book_dt")
	private Date ticketBookDate;
	@Column(name = "uid")
	private String uniqueId;
	private String source;
	private String destination;
	@Column(name = "travel_dt")
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date travelDate;

}
