package com.TicketBookingApp.Controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.TicketBookingApp.Model.TrainBookingDTO;
import com.TicketBookingApp.Service.TrainBookingService;


@RestController
@RequestMapping("/TicketBooking/TrainBooking")
public class TrainBookingController {
	
	@Autowired
	private TrainBookingService bookingService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping("/addTicket")
	public ResponseEntity<String> addNewBooking(@RequestBody TrainBookingDTO bookingDTO) throws Exception{
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
	public ResponseEntity<TrainBookingDTO> getTicketByName(@RequestParam ("name") String name) throws Exception{
		ResponseEntity<TrainBookingDTO> response=null;
		try {
			TrainBookingDTO	 bookingDTO=bookingService.getBookingByName(name);
			response=new ResponseEntity<TrainBookingDTO>(bookingDTO,HttpStatus.OK);
		}catch (Exception e) {
		 throw e;
		}
		return response;
	}
	
	@DeleteMapping("/deleteTicket")
	public ResponseEntity<String> deleteBooking(@RequestParam ("name") String name) throws Exception{
		ResponseEntity<String> response=null;
		try {
			String deletebooking=bookingService.deleteByName(name);
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
	
	@GetMapping("/getTicketByTrainNo")
	public ResponseEntity<List<TrainBookingDTO>> getTicketByTrainNo(@RequestParam ("trainno") String trainno) throws Exception{
		ResponseEntity<List<TrainBookingDTO>> response=null;
		try {
			List<TrainBookingDTO> bookingDTO=bookingService.getBookingListByTrainNo(trainno);
			response=new ResponseEntity<List<TrainBookingDTO>>(bookingDTO,HttpStatus.OK);
		}catch (Exception e) {
		 throw e;
		}
		return response;
	}
	@GetMapping("/getTicketByTrainName")
	public ResponseEntity<List<TrainBookingDTO>> getTicketByTrainName(@RequestParam ("trainname") String trainname) throws Exception{
		ResponseEntity<List<TrainBookingDTO>> response=null;
		try {
			List<TrainBookingDTO> bookingDTO=bookingService.getBookingListByTrainName(trainname);
			response=new ResponseEntity<List<TrainBookingDTO>>(bookingDTO,HttpStatus.OK);
		}catch (Exception e) {
		 throw e;
		}
		return response;
	}
	@GetMapping("/getTicketByDate")
	public ResponseEntity<List<TrainBookingDTO>> getTicketByDate(@RequestParam("Date") @DateTimeFormat(pattern= "yyyy-MM-dd") Date startDate) throws Exception{
		ResponseEntity<List<TrainBookingDTO>> response=null;
		try {
			List<TrainBookingDTO> bookingDTO=bookingService.getBookingListByDateOfJourney(startDate);
			response=new ResponseEntity<List<TrainBookingDTO>>(bookingDTO,HttpStatus.OK);
		}catch (Exception e) {
		 throw e;
		}
		return response;
	}
	
	

}
