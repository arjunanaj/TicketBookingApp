package com.TicketBookingApp.Model;

import java.util.Date;

import com.TicketBookingApp.Entity.TrainBooking;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TrainBookingDTO {
	
	
	private Integer id;
	private String name;
	private String  phoneNo;
	private String trainNo;
	private String trainName;
	private String journeyFrom;
	private String journeyTo;
	private Date dateOfBooking;
	private Date dateOfJourney;
	private Integer amount;
	
	
	public static TrainBooking createEntity(TrainBookingDTO bookingDTO) throws Exception{
		TrainBooking booking=new TrainBooking();
		booking.setName(bookingDTO.getName());
		booking.setPhoneNo(bookingDTO.getPhoneNo());
		booking.setTrainNo(bookingDTO.getTrainNo());
		booking.setTrainName(bookingDTO.getTrainName());
		booking.setJourneyFrom(bookingDTO.getJourneyFrom());
		booking.setDateOfBooking(new Date(System.currentTimeMillis()));
		booking.setDateOfJourney(bookingDTO.getDateOfJourney());
		booking.setJourneyTo(bookingDTO.getJourneyTo());
		booking.setDateOfJourney(bookingDTO.getDateOfJourney());
		booking.setAmount(bookingDTO.getAmount());
		return booking;
	}
	
	

}
