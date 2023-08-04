package com.TicketBookingApp.Repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TicketBookingApp.Entity.TrainBooking;
@Repository
public interface TrainBookingRepository extends JpaRepository<TrainBooking, String>{
	
	public Optional<TrainBooking>findByName(String name);
	public Optional<TrainBooking>deleteByName(String name);
	public List<TrainBooking>  findBytrainNo(String trainNo);
	public List<TrainBooking> findBytrainName(String trainName);
	public List<TrainBooking> findBydateOfJourney(Date from);
	
	

}
