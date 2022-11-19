package com.mail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Entity
public class Field {
	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer fieldid;
	@Column(length = 20)
	private String fieldname;
	@Transient	
//	@JsonIgnore
	private String value;
	/**
	 * Default Constructor
	 */
	public Field() {
		super();
	}
	
	/**
	 * @param fieldname
	 */
	public Field(String fieldname) {
	super();
	this.fieldname = fieldname;
	}

	/**
	 * @param fieldid -primary key
	 * @param fieldname -name of each field in template
	 */
	public Field(Integer fieldid, String fieldname) {
		super();
		this.fieldid = fieldid;
		this.fieldname = fieldname;
	}
	/**
	 * @return getter method for getting the fieldid of the corresponding object 
	 */
	public Integer getFieldid() {
		return fieldid;
	}
	/**
	 * @param fieldid
	 */
	public void setFieldid(Integer fieldid) {
		this.fieldid = fieldid;
	}
	/**
	 * @return getter method for getting the fieldname of the corresponding object 
	 */
	public String getFieldname() {
		return fieldname;
	}
	/**
	 * @param fieldname
	 */
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	
	/**
	 * @return getter method for getting the value of the corresponding object 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return String- returns String representation of our object
	 */
	@Override
	public String toString() {
		return "Field [fieldid=" + fieldid + ", fieldname=" + fieldname + ", value=" + value + "]";
	}
}
