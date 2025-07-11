package com.codegnan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(InvalidDoctorIdException.class)
	public ResponseEntity<ErrorResponse> meth1(InvalidDoctorIdException e) {
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND,e.getMessage());
		ResponseEntity<ErrorResponse> responseEntity=new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
		return responseEntity;
		
	}
	//PatientINvalid internalserver error
	@ExceptionHandler(InvalidPatientIdException.class)
	public ResponseEntity<ErrorResponse> meth2(InvalidPatientIdException e) {
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND,e.getMessage());
		ResponseEntity<ErrorResponse> responseEntity=new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
		return responseEntity;
	}
	@ExceptionHandler(InvalidDateFormatException.class)	
	public ResponseEntity<ErrorResponse> meth3(InvalidDateFormatException e) {
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND,e.getMessage());
		ResponseEntity<ErrorResponse> responseEntity=new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
		return responseEntity;
	}
	
	@ExceptionHandler(InvalidVisitIdException.class)	
	public ResponseEntity<ErrorResponse> meth4(InvalidVisitIdException e) {
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND,e.getMessage());
		ResponseEntity<ErrorResponse> responseEntity=new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
		return responseEntity;
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> meth5(Exception e) {
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		ResponseEntity<ErrorResponse> responseEntity=new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
		return responseEntity;
		
	}

}
