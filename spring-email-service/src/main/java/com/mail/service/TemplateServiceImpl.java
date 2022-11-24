package com.mail.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.exceptions.TemplateNotFoundException;
import com.mail.model.MailTemplate;
import com.mail.repository.ITemplateRepository;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Service
public class TemplateServiceImpl implements ITemplateService {

	private Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);
	
	@Autowired
	ITemplateRepository templateRepository;

	/**
	 * @param template - to add a template
	 */
	@Override
	public void addTemplate(MailTemplate template) {
		logger.info("Adding a new template to db"); 
		
		templateRepository.save(template);
	}

	/**
	 * @param template - to update the template
	 */
	@Override
	public void updateTemplate(MailTemplate template) {
		logger.info("Updaing the template into db");
		
		templateRepository.save(template);
	}

	/**
	 * @param templateid - to delete a template by its id
	 */
	@Override
	public void deleteTemplate(int templateid) {
		logger.info("Deleting template from db"); 

		templateRepository.deleteById(templateid);
	}

	/**
	 * @param templateid
	 * @return MailTemplate-to get the template by its id
	 */
	@Override
	public MailTemplate findById(int templateid) throws TemplateNotFoundException {
		logger.info("getting template for the corresponding templateid from db");
		
		Optional<MailTemplate> mailTemplate=templateRepository.findById(templateid);
		if(mailTemplate.isEmpty()) {
			throw new TemplateNotFoundException("The requested template id is not available");
		}
		return mailTemplate.get();
	}

	/**
	 * @return List<MailTemplate>-to get all the available templates
	 */
	@Override
	public List<MailTemplate> getAll() {
		logger.info("getting all the templates from db");

		return templateRepository.findAll();
	}

}
