package com.mail.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.model.Field;
import com.mail.model.MailRequest;
import com.mail.model.MailResponse;
import com.mail.model.MailTemplate;
import com.mail.service.IFieldService;
import com.mail.service.ITemplateService;
import com.mail.service.MailService;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@RestController
@RequestMapping("/template-mailing")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private IFieldService fieldService;
	
	@Autowired
	private ITemplateService templateService;
	
	private Logger logger = LoggerFactory.getLogger(MailController.class);
	
	/**
	 * @param request - the request that contains all the mail related inputs from the client
	 * @return MailResponse - gives message & status about sending the mail
	 */
	@PostMapping("/sendmail")
	public ResponseEntity<MailResponse> sendMail(@RequestBody MailRequest request) {
		logger.info("Intializing the process.....");
		List<Field> fields=request.getFields();
		System.out.println(fields);
		Map<String,Object> model=fields.stream().collect(Collectors.toMap(Field :: getFieldname, Field :: getValue));
		logger.info("----->---->--->-->->");
		
		return ResponseEntity.status(HttpStatus.OK).header("desc","Sending mail").body(mailService.sendEmail(request , model));
	}
	
	/**
	 * @return List<MailTemplate> - to get all the templates available
	 */
	@GetMapping("/get-templates")
	public ResponseEntity<List<MailTemplate>> greet(){
		logger.info("Getting all the available templates");
		return ResponseEntity.status(HttpStatus.OK).header("desc","Available templates are").body(templateService.getAll());
		
	}
	
	/**
	 * @param templateid - selecting the required template
	 * @return List<Field> - to return all the fields of a selected template
	 */
	@GetMapping("/templateid/{templateid}")
	public ResponseEntity<List<Field>> fieldDis(@PathVariable int templateid){
		String templateName=(templateService.findById(templateid)).getTemplatename();
		
		logger.info("Getting all the fields of the template:"+templateName);
		return ResponseEntity.status(HttpStatus.OK).header("desc","Getting all the fields of the template :"+templateName).body(fieldService.getByTemplateid(templateid));
	}
}
