package com.TicketBookingApp.Service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TicketBookingApp.Entity.BusBooking;
import com.TicketBookingApp.Model.BusBookingDTO;
import com.TicketBookingApp.Repository.BusBookingRepository;

@Service
@Transactional
public class BusBookingServiceImpl implements BusBookingService {

	@Autowired
	private BusBookingRepository bookingRepository;

	@Override
	public String addBooking(BusBookingDTO bookingDTO) throws Exception {
		BusBooking entity = null;
	
			Optional<BusBooking> optional = bookingRepository.findByname(bookingDTO.getName());
			if (optional.isPresent()) {
				throw new Exception("Service.Duplicate_Found");
			}
			entity = BusBookingDTO.createEntity(bookingDTO);
			bookingRepository.save(entity);
		
		

		return entity.getName();
	}

	@Override
	public BusBookingDTO getBookingByName(String name) throws Exception {
		Optional<BusBooking> optional = bookingRepository.findByname(name);
		BusBooking entity = optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		BusBookingDTO bookingDTO = BusBooking.createDto(entity);
		return bookingDTO;
	}

	@Override
	public String deleteBookingByName(String name) throws Exception {
		Optional<BusBooking> optional = bookingRepository.findByname(name);
		BusBooking entity = optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		bookingRepository.delete(entity);
		return entity.getName();
	}

	@Override
	public String updateBooking(BusBookingDTO bookingDTO, String name) throws Exception {
		Optional<BusBooking> optional = bookingRepository.findByname(name);
		BusBooking entity = optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		if(Objects.nonNull(bookingDTO.getName())&&!"".equalsIgnoreCase(bookingDTO.getName())) {
			entity.setName(bookingDTO.getName());
		}
		else {
			entity.setName(entity.getName());
		}
		if(Objects.nonNull(bookingDTO.getStartFrom())&&!"".equalsIgnoreCase(bookingDTO.getStartFrom())) {
			entity.setStartFrom(bookingDTO.getStartFrom());
		}else {
			entity.setStartFrom(entity.getStartFrom());
		}
		if(Objects.nonNull(bookingDTO.getEndTo())&&!"".equalsIgnoreCase(bookingDTO.getEndTo())) {
			entity.setEndTo(bookingDTO.getEndTo());
		}else {
			entity.setEndTo(entity.getEndTo());
		}
		
		bookingRepository.save(entity);
		
		return entity.getName();
	}

}
