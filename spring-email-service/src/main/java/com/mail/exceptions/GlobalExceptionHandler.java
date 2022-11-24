package com.mail.exceptions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mail.model.APIErrors;

import freemarker.template.TemplateException;


/**
 * @author SENTHILKUMARMAHESWARAN
 * 
 * DESC : Handling all possible exceptions to provide user friendly info to the client
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * @param ex - contains stack trace
	 * @param headers - this'll contain the in-build headers for this HttpRequestMethodNotSupportedException
	 * @param status - corresponding status code 
	 * @param request - this'll have the corresponding request that caused this exception
	 * @return ResponseEntity<Object>- the stack trace is made into a user friendly message
	 * 
	 * Triggered when client uses inappropriate method in HttpRequest
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.warn("Handling Http Request method not supported exception....");

		String msg=ex.getMessage();
		headers.add("desc", "use appropriate method");
		String error="Request method not supported";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, status, status.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, status);
		
		return entity;
	}

	/**
	 * @param ex - contains stack trace
	 * @param headers - this'll contain the in-build headers for this HttpMediaTypeNotSupportedException
	 * @param status - corresponding status code 
	 * @param request - this'll have the corresponding request that caused this exception
	 * @return ResponseEntity<Object>- the stack trace is made into a user friendly message
	 * 
	 * Triggered when client gives input in different media type except JSON
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.warn("Handling Http Media type not supported exception....");

		String msg=ex.getMessage();
		headers.add("desc", "use appropriate media type");
		String error="Request media type not supported";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, status, status.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, status);
		return entity;
	}

	/**
	 * @param ex - contains stack trace
	 * @param headers - this'll contain the in-build headers for this MissingPathVariableException
	 * @param status - corresponding status code 
	 * @param request - this'll have the corresponding request that caused this exception
	 * @return ResponseEntity<Object>- the stack trace is made into a user friendly message
	 * 
	 * Triggered when user doesn't use path variable while client passing values through url.
	 */
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.warn("Handling Missing path variable exception....");

		String msg=ex.getMessage();
		headers.add("desc", "provide path variable");
		String error="Missing path variable";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, status, status.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, status);
		return entity;
	}

	/**
	 * @param ex - contains stack trace
	 * @param headers - this'll contain the in-build headers for this MissingServletRequestParameterException
	 * @param status - corresponding status code 
	 * @param request - this'll have the corresponding request that caused this exception
	 * @return ResponseEntity<Object>- the stack trace is made into a user friendly message
	 * 
	 * Triggered when requestparam was missing. 
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.warn("Handling Missing servlet request parameter exception....");

		String msg=ex.getMessage();
		headers.add("desc", "use request parameter");
		String error="Missing servlet request parameter";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, status, status.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, status);
		return entity;
	}

	/**
	 * @param ex - contains stack trace
	 * @param headers - this'll contain the in-build headers for this TypeMismatchException
	 * @param status - corresponding status code 
	 * @param request - this'll have the corresponding request that caused this exception
	 * @return ResponseEntity<Object>- the stack trace is made into a user friendly message
	 * 
	 * Triggered when user gives String value in place of int values
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.warn("Handling Http message not readable exception....");

		String msg=ex.getMessage();
		headers.add("desc", "Check for the value");
		String error="Template Not Found Exception";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, HttpStatus.CONFLICT);
		return entity;
	}

	/**
	 * @param ex - contains stack trace
	 * @return ResponseEntity<Object>- the stack trace is made into a user friendly message
	 * Base exception for all messaging exceptions
	 */
	@ExceptionHandler(MessagingException.class)
	public ResponseEntity<Object> handleMessagingException(MessagingException ex){
		logger.warn("Handling messaging exception....");

		String msg=ex.getMessage();
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Connection failed");
		String error="Messging Exception";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, HttpStatus.UNAUTHORIZED);
		return entity;
	}
	
	/**
	 * @param ex - contains stack trace
	 * @return ResponseEntity<Object>- the stack trace is made into a user friendly message
	 * This exceptions produced by failed or interrupted I/O operations.
	 */
	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> handleIOException(IOException ex){
		logger.warn("Handling IO exception....");

		String msg=ex.getMessage();
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Cannot read the files attached");
		String error="IO exception";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, HttpStatus.NOT_ACCEPTABLE, HttpStatus.NOT_ACCEPTABLE.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, HttpStatus.NOT_ACCEPTABLE);
		return entity;
	}

	/**
	 * @param ex - contains stack trace
	 * @return ResponseEntity<Object>- the stack trace is made into a user friendly message
	 * This'll be thrown when template was not found,format was different from required one etc.... 
	 */
	@ExceptionHandler(TemplateException.class)
	public ResponseEntity<Object> handleTemplateException(TemplateException ex){
		logger.warn("Handling template exception....");

		String msg=ex.getMessage();
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Connection failed");
		String error="Messging Exception";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, HttpStatus.UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, HttpStatus.UNPROCESSABLE_ENTITY);
		return entity;
	}

	/**
	 * @param ex - contains stack trace
	 * @return ResponseEntity<Object>-the stack trace is made into a user friendly message
	 * Triggered when the template given by the client is not available 
	 */
	@ExceptionHandler(TemplateNotFoundException.class)
	public ResponseEntity<Object> handleTemplateNotFoundException(TemplateNotFoundException ex){
		logger.warn("Handling template not found exception....");

		String msg=ex.getMessage();
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Check the template Id entered");
		String error="Template Not Found Exception";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
	/**
	 * @param ex - contains stack trace
	 * @return ResponseEntity<Object>-the stack trace is made into a user friendly message
	 * Triggered when the field provided by the client is not available 
	 */
	@ExceptionHandler(FieldNotFoundException.class)
	public ResponseEntity<Object> handleFieldNotFoundException(FieldNotFoundException ex){
		logger.warn("Handling field not found exception....");

		String msg=ex.getMessage();
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Check the entered fields");
		String error="Field Not Found Exception";
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

	/**
	 * @param ex - contains stack trace
	 * @return ResponseEntity<Object>-the stack trace is made into a user friendly message
	 * If any other unhandled exception occurs this exception will be thrown 
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex){
		logger.warn("Handling generic exception....-other exception has occured");

		String msg=ex.getMessage();
		HttpHeaders headers=new HttpHeaders();
		String error="Other Exception\n"+ex.getStackTrace();
		APIErrors errors=new APIErrors(LocalDateTime.now(), msg, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		ResponseEntity<Object> entity=new ResponseEntity<Object>(errors, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	

}
