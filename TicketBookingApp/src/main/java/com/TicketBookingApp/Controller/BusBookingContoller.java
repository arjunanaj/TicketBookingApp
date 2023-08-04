package com.TicketBookingApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TicketBookingApp.Model.BusBookingDTO;
import com.TicketBookingApp.Service.BusBookingService;

@RestController
@RequestMapping("/TicketBooking/BusBooking")
public class BusBookingContoller {
	
	@Autowired
	private BusBookingService bookingService;
	@Autowired
	private Environment environment;
	
	
	@PostMapping("/addTicket")
	public ResponseEntity<String> addNewBooking(@RequestBody BusBookingDTO bookingDTO) throws Exception{
		ResponseEntity<String> response=null;
		try {
			String addbooking=bookingService.addBooking(bookingDTO);
			String message=environment.getProperty("UserInterface.ADD_SUCCESS") +addbooking;
			response=new ResponseEntity<String>(message,HttpStatus.CREATED);
		}catch (Exception e) {
			if(e.getMessage()!=null) {
				String message="Opps! Something Went Wrong" +" "+environment.getProperty(e.getMessage());
				response=new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
			}
			
		}
		return response;
	}
	
	
	@GetMapping("/getTicket")
	public ResponseEntity<BusBookingDTO> getTicketByName(@RequestParam ("name") String name) throws Exception{
		ResponseEntity<BusBookingDTO> response=null;
		try {
			BusBookingDTO bookingDTO=bookingService.getBookingByName(name);
			response=new ResponseEntity<BusBookingDTO>(bookingDTO,HttpStatus.OK);
		}catch (Exception e) {
		 throw e;
		}
		return response;
	}
	
	@DeleteMapping("/deleteTicket")
	public ResponseEntity<String> deleteBooking(@RequestParam ("name") String name) throws Exception{
		ResponseEntity<String> response=null;
		try {
			String deletebooking=bookingService.deleteBookingByName(name);
			String message=environment.getProperty("UserInterface.DELETE_SUCCESS") +deletebooking;
			response=new ResponseEntity<String>(message,HttpStatus.OK);
		}catch (Exception e) {
			if(e.getMessage()!=null) {
				String message="Opps! Something Went Wrong" +" "+environment.getProperty(e.getMessage());
				response=new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
			}
		}
		return response;
	}
	@PutMapping("/updateTicket")
	public ResponseEntity<String> UpdateBooking(@RequestParam ("name") String name,@RequestBody BusBookingDTO bookingDTO) throws Exception{
		ResponseEntity<String> response=null;
		try {
			String updatebooking=bookingService.updateBooking(bookingDTO, name);
			String message=environment.getProperty("UserInterface.UPDATE_SUCCESS") +updatebooking;
			response=new ResponseEntity<String>(message,HttpStatus.OK);
		}catch (Exception e) {
			if(e.getMessage()!=null) {
				String message="Opps! Something Went Wrong" +" "+environment.getProperty(e.getMessage());
				response=new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
			}
		}
		return response;
	}

}
