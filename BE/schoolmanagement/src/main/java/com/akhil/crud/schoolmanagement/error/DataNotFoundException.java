package com.akhil.crud.schoolmanagement.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * custom exception handling for no data
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException  extends Exception{
    private static final long serialVersionUID = 1L;
    
    public DataNotFoundException(String message){
    	super(message);
    }
}
