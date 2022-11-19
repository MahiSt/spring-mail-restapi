package com.mail.model;

import org.springframework.stereotype.Component;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Component
public class MailResponse {
	private String msg;
	private Boolean status;
	
	/**
	 * Default Constructor
	 */
	public MailResponse() {
		super();
	}
	/**
	 * @param msg
	 * @param status
	 */
	public MailResponse(String msg, Boolean status) {
		super();
		this.msg = msg;
		this.status = status;
	}
	/**
	 * @return getter method for getting the fields of the corresponding object 
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return getter method for getting the fields of the corresponding object 
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	/**
	 * @return String- returns String representation of our object
	 */
	@Override
	public String toString() {
		return "MailResponse [msg=" + msg + ", status=" + status + "]";
	}
	
}
