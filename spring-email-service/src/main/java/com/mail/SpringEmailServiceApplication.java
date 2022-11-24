package com.mail;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.mail.model.Field;
import com.mail.model.MailTemplate;
import com.mail.service.ITemplateService;

/**
 * @author SENTHILKUMARMAHESWARAN 
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringEmailServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailServiceApplication.class, args);
	}

	@Autowired
	private ITemplateService templateService;

	private Logger logger = LoggerFactory.getLogger(SpringEmailServiceApplication.class);

	/**
	 * @param args
	 * @throws Exception
	 * 
	 * DESC : Adding templates and its fields to the db.
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info("Setting up all the template and field details to DB");

//		templateService.addTemplate(new MailTemplate("remainder","C:\\Users\\SENTHILKUMARMAHESWAR\\Desktop\\Template",Arrays.asList(new Field("name"),new Field("location"),new Field("link"))));
//
//		List<Field> fields=Arrays.asList(new Field("fathername"),new Field("bride"),new Field("broom"),new Field("day"),new Field("date"),new Field("month"),new Field("year"),new Field("hour"),new Field("session"),new Field("hallname"),new Field("street"),new Field("city"),new Field("state"),new Field("link"));
//		templateService.addTemplate(new MailTemplate("marriage-invitation","C:\\Users\\SENTHILKUMARMAHESWAR\\Desktop\\Template",fields));
//
//		fields=Arrays.asList(new Field("name"),new Field("announcer"),new Field("day"),new Field("date"),new Field("project"),new Field("part"),new Field("link"));
//		templateService.addTemplate(new MailTemplate("announcement","C:\\Users\\SENTHILKUMARMAHESWAR\\Desktop\\Template",fields));
//
//		fields=Arrays.asList(new Field("leavetype"),new Field("name"),new Field("employer"),new Field("noofdays"),new Field("startdate"),new Field("enddate"),new Field("reason"),new Field("substitute"),new Field("phonenumber"),new Field("email"));
//		templateService.addTemplate(new MailTemplate("leave-request","C:\\Users\\SENTHILKUMARMAHESWAR\\Desktop\\Template",fields));
//
//		fields=Arrays.asList(new Field("name"),new Field("link"));
//		templateService.addTemplate(new MailTemplate("ad","C:\\Users\\SENTHILKUMARMAHESWAR\\Desktop\\Template",fields));
		logger.info("Setting up done");
	}


	
}
