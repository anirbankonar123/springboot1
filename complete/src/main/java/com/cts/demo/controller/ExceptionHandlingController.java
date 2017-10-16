package com.cts.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cts.demo.exception.*;

@ControllerAdvice
public class ExceptionHandlingController {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandlingController.class);
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("100");
        response.setErrorMessage(ex.getMessage());
        log.info("inside exc handler");
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
}
