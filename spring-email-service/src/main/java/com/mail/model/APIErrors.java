package com.mail.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */

public class APIErrors {
	
	LocalDateTime localDateTime;
	String message;
	HttpStatus status;
	int statuscode;
	String error;
	/**
	 * Default Constructor
	 */
	public APIErrors() {
		super();
	}
	
	/**
	 * @param localDateTime -provides information about when did the error occured
	 * @param message -to give information about what error has occured
	 * @param status -indicates the status 
	 * @param statuscode -provides error specific code
	 * @param error -this contains stack trace of the error
	 */
	public APIErrors(LocalDateTime localDateTime, String message, HttpStatus status, int statuscode, String error) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.status = status;
		this.statuscode = statuscode;
		this.error = error;
	}
	/**
	 * @return getter method for getting the localDateTime of the corresponding object 
	 */
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	/**
	 * @param localDateTime
	 */
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	/**
	 * @return getter method for getting the status of the corresponding object 
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return getter method for getting the message of the corresponding object 
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return getter method for getting the statuscode of the corresponding object 
	 */
	public int getStatuscode() {
		return statuscode;
	}
	/**
	 * @param statuscode
	 */
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	/**
	 * @return getter method for getting the error of the corresponding object 
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return String- returns String representation of our object
	 */
	@Override
	public String toString() {
		return "APIErrors [localDateTime=" + localDateTime + ", status=" + status + ", message=" + message
				+ ", statuscode=" + statuscode + ", error=" + error + "]";
	}
}
