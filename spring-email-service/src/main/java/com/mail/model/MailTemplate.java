package com.mail.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Entity
public class MailTemplate {
	@Id
	@GeneratedValue(generator = "template_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "template_seq",sequenceName = "template_sequence",initialValue = 100,allocationSize = 1)
	private Integer templateid;
	@Column(length = 20)
	private String templatename;
	@Column(nullable = false)
	@JsonIgnore
	private String path;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "template_id")
	@JsonIgnore
	private List<Field> fields;
	
	/**
	 * Default constructor
	 */
	public MailTemplate() {
		super();
	}
	
	/**
	 * @param templatename - name of each template
	 * @param path -path were it is stored
	 * @param fields - To get list of fields in the template
	 */
	public MailTemplate(String templatename, String path, List<Field> fields) {
		super();
		this.templatename = templatename;
		this.path=path;
		this.fields = fields;
	}

	/**
	 * @param templateid
	 * @param templatename
	 * @param path -path were it is stored
	 * @param fields
	 */
	public MailTemplate(Integer templateid, String templatename, String path, List<Field> fields) {
		super();
		this.templateid = templateid;
		this.templatename = templatename;
		this.path=path;
		this.fields = fields;
	}
	/**
	 * @return getter method for getting the templateid of the corresponding object 
	 */
	public Integer getTemplateid() {
		return templateid;
	}
	/**
	 * @param templateid
	 */
	public void setTemplateid(Integer templateid) {
		this.templateid = templateid;
	}
	/**
	 * @return getter method for getting the templatename of the corresponding object 
	 */
	public String getTemplatename() {
		return templatename;
	}	
	/**
	 * @param templatename
	 */
	public void setTemplatename(String templatename) {
		this.templatename = templatename;
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return String- returns String representation of our object
	 */
	@Override
	public String toString() {
		return "Template [templateid=" + templateid + ", templatename=" + templatename + "]";
	}
	
}
