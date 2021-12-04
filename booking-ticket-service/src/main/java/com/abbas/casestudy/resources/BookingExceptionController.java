package com.abbas.casestudy.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.exception.TicketNotfoundException;


@ControllerAdvice
public class BookingExceptionController {

	@ExceptionHandler(value = TicketNotfoundException.class)
	public ResponseEntity<Object> exception(TicketNotfoundException exception){
		return new ResponseEntity<>("Ticket not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmptyInputException.class)
	public ResponseEntity<Object> exception(EmptyInputException exception){
		return new ResponseEntity<>("Input Field is Empty",HttpStatus.BAD_REQUEST);
	}
}
