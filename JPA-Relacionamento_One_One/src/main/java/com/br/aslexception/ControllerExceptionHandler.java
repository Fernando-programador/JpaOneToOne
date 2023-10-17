package com.br.aslexception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerAllException(
			Exception ex, WebRequest req){
		ExceptionResponse  response = new ExceptionResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				new Date(), 
				ex.getMessage(), 
				req.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> resouceNotFoundException(
			Exception ex, WebRequest req){
		ExceptionResponse  response = new ExceptionResponse(
				HttpStatus.NOT_FOUND.value(), 
				new Date(), 
				ex.getMessage(), 
				req.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
