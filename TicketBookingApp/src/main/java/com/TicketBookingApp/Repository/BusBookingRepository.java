package com.TicketBookingApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TicketBookingApp.Entity.BusBooking;
@Repository
public interface BusBookingRepository extends JpaRepository<BusBooking, String> {
	Optional<BusBooking> findByname(String name);


}
