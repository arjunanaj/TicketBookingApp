package com.TicketBookingApp.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TicketBookingApp.Entity.TrainBooking;
import com.TicketBookingApp.Model.TrainBookingDTO;
import com.TicketBookingApp.Repository.TrainBookingRepository;
import com.TicketBookingApp.Validation.Validation;

@Service
public class TrainBookingServiceImpl implements TrainBookingService {

	@Autowired
	private TrainBookingRepository bookingTrainBookingRepository;
	@Autowired
	private Validation validation;

	@Override
	public String addBooking(TrainBookingDTO bookingDTO) throws Exception {
		Optional<TrainBooking> optional = bookingTrainBookingRepository.findByName(bookingDTO.getName());
		if (optional.isPresent()) {
			throw new Exception("Service.Duplicate_Found");
		}
		else if (!(validation.numberValidation(bookingDTO.getPhoneNo()))) {
			throw new Exception("Service.invalid_Format");
		}
	
		TrainBooking trainBooking = TrainBookingDTO.createEntity(bookingDTO);
		bookingTrainBookingRepository.save(trainBooking);
		return trainBooking.getName();
	}

	@Override
	public TrainBookingDTO getBookingByName(String name) throws Exception {
		Optional<TrainBooking> optional = bookingTrainBookingRepository.findByName(name);
		TrainBooking trainBooking = optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		TrainBookingDTO trainBookingDTO = TrainBooking.createDto(trainBooking);
		return trainBookingDTO;
	}

	@Override
	public String deleteByName(String name) throws Exception {
		Optional<TrainBooking> optional = bookingTrainBookingRepository.deleteByName(name);
		TrainBooking entity = optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		bookingTrainBookingRepository.deleteByName(name);
		return entity.getName();

	}

	@Override
	public List<TrainBookingDTO> getBookingListByTrainNo(String trainno) throws Exception {
		List<TrainBookingDTO> bookingDTOs = new ArrayList<>();
		List<TrainBooking> bookings = bookingTrainBookingRepository.findBytrainNo(trainno);
		if (bookings.isEmpty()) {
			throw new Exception("Service.List_Empty");
		}
		for (TrainBooking booking : bookings) {
			bookingDTOs.add(TrainBooking.createDto(booking));
		}
		return bookingDTOs;
	}

	@Override
	public List<TrainBookingDTO> getBookingListByTrainName(String trainname) throws Exception {
		List<TrainBookingDTO> bookingDTOs = new ArrayList<>();
		List<TrainBooking> bookings = bookingTrainBookingRepository.findBytrainName(trainname);
		if (bookings.isEmpty()) {
			throw new Exception("Service.List_Empty");
		}
		for (TrainBooking booking : bookings) {
			bookingDTOs.add(TrainBooking.createDto(booking));
		}
		return bookingDTOs;

	}

	@Override
	public List<TrainBookingDTO> getBookingListByDateOfJourney(Date date) throws Exception {
		List<TrainBookingDTO> bookingDTOs = new ArrayList<>();
		List<TrainBooking> bookings = bookingTrainBookingRepository.findBydateOfJourney(date);
		if (bookings.isEmpty()) {
			throw new Exception("Service.List_Empty");
		}
		for (TrainBooking booking : bookings) {
			bookingDTOs.add(TrainBooking.createDto(booking));
		}
		return bookingDTOs;

	}

}
