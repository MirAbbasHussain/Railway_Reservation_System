package com.abbas.casestudy.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.exception.TrainNotfoundException;

@ControllerAdvice
public class TrainExceptionController {
	
	@ExceptionHandler(value = TrainNotfoundException.class)
	public ResponseEntity<Object> exception(TrainNotfoundException exception){
		return new ResponseEntity<>("Train not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmptyInputException.class)
	public ResponseEntity<Object> exception(EmptyInputException exception){
		return new ResponseEntity<>("Input Field is Empty",HttpStatus.BAD_REQUEST);
	}
}
