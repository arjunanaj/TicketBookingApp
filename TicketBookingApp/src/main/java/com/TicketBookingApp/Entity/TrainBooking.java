package com.TicketBookingApp.Entity;

import java.util.Date;

import com.TicketBookingApp.Model.TrainBookingDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TrainBooking")
public class TrainBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public static TrainBookingDTO createDto(TrainBooking booking) throws Exception{
		TrainBookingDTO bookingDTO=new TrainBookingDTO();
		bookingDTO.setId(booking.getId());
		bookingDTO.setName(booking.getName());
		bookingDTO.setPhoneNo(booking.getPhoneNo());
		bookingDTO.setTrainNo(booking.getTrainNo());
		bookingDTO.setTrainName(booking.getTrainName());
		bookingDTO.setJourneyFrom(booking.getJourneyFrom());
		bookingDTO.setJourneyTo(booking.getJourneyTo());
		bookingDTO.setDateOfBooking(booking.getDateOfBooking());
		bookingDTO.setDateOfJourney(booking.getDateOfJourney());
		bookingDTO.setAmount(booking.getAmount());
		return bookingDTO;
	}

}
