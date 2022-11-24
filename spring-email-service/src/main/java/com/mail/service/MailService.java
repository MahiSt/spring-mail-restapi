package com.mail.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.mail.exceptions.FieldNotFoundException;
import com.mail.exceptions.TemplateNotFoundException;
import com.mail.model.Field;
import com.mail.model.MailRequest;
import com.mail.model.MailResponse;
import com.mail.model.MailTemplate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private Configuration config;
	@Autowired
	private ITemplateService templateService;
	private Logger logger = LoggerFactory.getLogger(MailService.class);
	
	/**
	 * @param request - Contains all the details to send the mail
	 * @param model - Has all the fields and its values as a key-value pair
	 * @return MailResponse -returns the response of the mail
	 * @throws TemplateNotFoundException - triggered when the template requested not found,
	 * @throws FieldNotFoundException-triggered when the field entered not found
	 */
	public MailResponse sendEmail(MailRequest request,Map<String,Object> model) throws TemplateNotFoundException,FieldNotFoundException{
		
		logger.info("Into sendmail method.....");
		
		MailResponse customResponse =new MailResponse();
		
		//this creates a SmartMimeMessage, that holds default encoding and default FileTypeMap
		MimeMessage message=mailSender.createMimeMessage();
		
		try {
			MailTemplate mailTemplate=templateService.findById(request.getTemplateid());
			
			if(mailTemplate==null) {
				logger.error("Template not found exception is thrown...");
				throw new TemplateNotFoundException("Entered template does not exists");
			}
			
			if(mailTemplate.getFields().size()!=model.size()) {
				logger.error("Field not found exception is thrown - numbers differ...");
				throw new FieldNotFoundException("Entered fields does not match the template");
			}
			
			if(!checker(model,mailTemplate.getFields())) {
				logger.error("Field not found exception is thrown - field unavailable...");
				throw new FieldNotFoundException("Entered field is not available");	
			}
			
			//set mediatype 
			//MimeMessageHelper - helps to setting up the email 
			MimeMessageHelper mailDetails=new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());
			
			//add attachment
			logger.info("Getting file path from db.....");
			config.setDirectoryForTemplateLoading(new File(mailTemplate.getPath()));

			logger.info("Getting template from the path.....");
			Template template=config.getTemplate(mailTemplate.getTemplatename()+".ftl");
			
			logger.info("Filling templates with the provided field values.....");
			String mailBody=FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
			
			logger.info("Retriving details from request and setting them to mail.....");
			mailDetails.setTo(request.getTo());
			/**
			 * setText - Setting body for the mail
			 */
			mailDetails.setText(mailBody,true);
			mailDetails.setSubject(request.getSub());
			mailDetails.setFrom(request.getFrom());
			
			mailSender.send(message);
			
			logger.info("Retrived details. Sending.......");
			
			customResponse.setMsg("mail send to: "+Arrays.toString(request.getTo()));
			customResponse.setStatus(Boolean.TRUE);
			
			logger.info("Sent successfully.....");
			
		}catch(MessagingException | IOException | TemplateException e) {
			logger.error("Exception is thrown while sending mail...");
			customResponse.setMsg("mail sending failure: "+request.getTo());
			customResponse.setStatus(Boolean.FALSE);
		}
		logger.info("Sending response.....");
		return customResponse;
	}
	
	/**
	 * @param model
	 * @param fields
	 * @return boolean- this method checks for the fields given by client and the available fields of corresponding template
	 * if any field is not there then it returns false or else returns true
	 */
	private boolean checker(Map<String,Object> model,List<Field> fields) {
		logger.info("Checking for fields available with those provided by the client.....");
		for(Field field: fields) {
			if(!model.containsKey(field.getFieldname())) {
				logger.info("Oopss!!!....Wrong field provided....");
				return false;
			}
		}
		logger.info("Checked..All good....");		
		return true;
	}
}
