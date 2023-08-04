package com.TicketBookingApp.Model;



import java.sql.Date;

import com.TicketBookingApp.Entity.BusBooking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusBookingDTO {
	
	private Integer id;
	private String name;
	private String startFrom;
	private String endTo;
	private Date  dateOfJourney;
	private Integer amount;
	
	
	public static BusBooking createEntity(BusBookingDTO bookingDTO) {
		BusBooking busBooking=new BusBooking();
		busBooking.setName(bookingDTO.getName());
		busBooking.setStartFrom(bookingDTO.getStartFrom());
		busBooking.setEndTo(bookingDTO.getEndTo());
		busBooking.setDateOfJourney(bookingDTO.getDateOfJourney());
		busBooking.setAmount(bookingDTO.getAmount());
		return busBooking;
	}



}
