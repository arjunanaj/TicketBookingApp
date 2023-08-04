package com.TicketBookingApp.Service;

import java.util.Date;
import java.util.List;

import com.TicketBookingApp.Model.TrainBookingDTO;

public interface TrainBookingService {
    
	public String addBooking(TrainBookingDTO bookingDTO) throws Exception;
	public TrainBookingDTO getBookingByName(String name) throws Exception;
	public String deleteByName(String name) throws Exception;
	public List<TrainBookingDTO> getBookingListByTrainNo(String trainno)throws Exception;
	public List<TrainBookingDTO> getBookingListByTrainName(String trainname)throws Exception;
	public List<TrainBookingDTO> getBookingListByDateOfJourney(Date date)throws Exception;
	

}
