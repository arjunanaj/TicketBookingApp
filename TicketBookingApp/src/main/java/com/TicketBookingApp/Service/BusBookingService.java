package com.TicketBookingApp.Service;

import com.TicketBookingApp.Model.BusBookingDTO;

public interface BusBookingService {
	
	public String addBooking(BusBookingDTO bookingDTO) throws Exception;
	public BusBookingDTO getBookingByName(String name) throws Exception;
	public String  deleteBookingByName(String name) throws Exception;
	public String updateBooking(BusBookingDTO bookingDTO,String name) throws Exception;
	

}
