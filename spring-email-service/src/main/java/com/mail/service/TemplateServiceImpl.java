package com.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.model.MailTemplate;
import com.mail.repository.ITemplateRepository;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Service
public class TemplateServiceImpl implements ITemplateService {

	@Autowired
	ITemplateRepository templateRepository;
	
	/**
	 * @param template - to add a template
	 */
	@Override
	public void addTemplate(MailTemplate template) {
		templateRepository.save(template);
	}

	/**
	 * @param template - to update the template
	 */
	@Override
	public void updateTemplate(MailTemplate template) {
		templateRepository.save(template);
	}

	/**
	 * @param templateid - to delete a template by its id
	 */
	@Override
	public void deleteTemplate(int templateid) {
		templateRepository.deleteById(templateid);
	}

	/**
	 * @param templateid
	 * @return MailTemplate-to get the template by its id
	 */
	@Override
	public MailTemplate findById(int templateid) {
		return 	templateRepository.findById(templateid).get();
	}

	/**
	 * @return List<MailTemplate>-to get all the available templates
	 */
	@Override
	public List<MailTemplate> getAll() {
		return templateRepository.findAll();
	}

}
