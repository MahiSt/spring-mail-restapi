package com.mail.service;

import java.util.List;

import com.mail.model.MailTemplate;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
public interface ITemplateService {
	void addTemplate(MailTemplate template);
	void updateTemplate(MailTemplate template);
	void deleteTemplate(int templateid);
	MailTemplate findById(int templateid);
	
	List<MailTemplate> getAll();
}
