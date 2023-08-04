package com.TicketBookingApp.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	
	public boolean numberValidation(String phoneNo) {
		String regex= "^[+]{1}(?:[0-9\\-\\(\\)\\/\\.]\\s?){6,15}[0-9]{1}$";
		 Pattern p = Pattern.compile(regex);
		 Matcher m = p.matcher(phoneNo);
		 return  m.matches();

	
	}
	
	

	 

}
