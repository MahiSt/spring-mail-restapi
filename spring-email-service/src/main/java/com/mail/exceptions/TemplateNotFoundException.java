package com.mail.exceptions;

/**
 * @author SENTHILKUMARMAHESWARAN
 * Superclass -RuntimeException
 */
public class TemplateNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This will call the its superclass which is runtime exception
	 */
	public TemplateNotFoundException() {
		super();
	}

	/**
	 * @param message -This will throw the exception with custom message
	 */
	public TemplateNotFoundException(String message) {
		super(message);
	}

}
