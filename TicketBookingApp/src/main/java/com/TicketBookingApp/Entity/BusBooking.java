package com.TicketBookingApp.Entity;



import java.sql.Date;

import com.TicketBookingApp.Model.BusBookingDTO;

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
@Table(name = "BusBooking")
public class BusBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer id;
	private String name;
	private String startFrom;
	private String endTo;
	private Date  dateOfJourney;
	private Integer amount;
	

	
	public static BusBookingDTO createDto(BusBooking booking) {
		BusBookingDTO busBookingDTO=new BusBookingDTO();
		busBookingDTO.setId(booking.getId());
		busBookingDTO.setName(booking.getName());
		busBookingDTO.setStartFrom(booking.getStartFrom());
		busBookingDTO.setEndTo(booking.getEndTo());
		busBookingDTO.setDateOfJourney(booking.getDateOfJourney());
		busBookingDTO.setAmount(booking.getAmount());
		return busBookingDTO;
	}

}
