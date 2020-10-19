package com.akhil.crud.schoolmanagement.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
/*
 * Custom exception handler
 * It is the global exception handler
 */
@ControllerAdvice
public class CustomExceptionHandler {
	
	/*
	 * handles data not found exceptions
	 */
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(DataNotFoundException ex, WebRequest request) {
         ErrorDetail errorDetails = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<ErrorDetail>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    /*
     * handles unspecified exception
     */

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetail errorDetails = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetail>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}