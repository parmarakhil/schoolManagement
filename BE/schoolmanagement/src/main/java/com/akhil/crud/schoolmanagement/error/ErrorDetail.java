package com.akhil.crud.schoolmanagement.error;

import java.util.Date;

/*
 * Capture error details
 */
public class ErrorDetail {
	/*
	 * Time of error
	 */
    private Date timestamp;
    /*
     * error message
     */
    private String message;
    /*
     * some details about error
     */
    private String details;

    public ErrorDetail(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
         return message;
    }

    public String getDetails() {
         return details;
    }
}
