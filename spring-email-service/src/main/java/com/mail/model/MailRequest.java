package com.mail.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Component
public class MailRequest {
	
	private String[] to;
	private String from;
	private String sub;
	private int templateid;
	private List<Field> fields;
	
	/**
	 * Default Constructor
	 */
	public MailRequest() {
		super();
	}
	/**
	 * @param to -all the to mails was given as array 
	 * @param from - from address of the mail
	 * @param sub - to give the subject of the mail
	 * @param templateid - to select a particular template from a set of templates
	 * @param fields -to give editable fields of each template 
	 */
	public MailRequest(String[] to, String from, String sub, int templateid,
			List<Field> fields) {
		super();
		this.to = to;
		this.from = from;
		this.sub = sub;
		this.templateid = templateid;
		this.fields = fields;
	}
	/**
	 * @return getter method for getting the to of the corresponding object 
	 */
	public String[] getTo() {
		return to;
	}
	/**
	 * @param to
	 */
	public void setTo(String[] to) {
		this.to = to;
	}
	/**
	 * @return getter method for getting the from of the corresponding object 
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return getter method for getting the sub of the corresponding object 
	 */
	public String getSub() {
		return sub;
	}
	/**
	 * @param sub
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}
	/**
	 * @return getter method for getting the templateid of the corresponding object 
	 */
	public int getTemplateid() {
		return templateid;
	}
	/**
	 * @param templateid
	 */
	public void setTemplateid(int templateid) {
		this.templateid = templateid;
	}
	/**
	 * @return getter method for getting the fields of the corresponding object 
	 */
	public List<Field> getFields() {
		return fields;
	}
	/**
	 * @param fields
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	/**
	 * @return String- returns String representation of our object
	 */
	@Override
	public String toString() {
		return "MailRequest [to=" + to + ", from=" + from + ", sub=" + sub
				+ ", templateid=" + templateid + ", fields=" + fields + "]";
	}
	
}