package com.mail.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.model.Field;
import com.mail.repository.IFieldRepository;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Service
public class FieldServiceImpl implements IFieldService{
	
	private Logger logger = LoggerFactory.getLogger(FieldServiceImpl.class);

	@Autowired
	IFieldRepository fieldRepository;

	/**
	 * @param field - the field to be added
	 */
	@Override
	public void addField(Field field) {
		logger.info("Adding a new field to db"); 

		fieldRepository.save(field);
	}

	/**
	 * @param field - updating already existing field
	 */
	@Override
	public void updatefield(Field field) {
		logger.info("Updating the template into db"); 

		fieldRepository.save(field);		
	}

	/**
	 * @param fieldid - to delete the field
	 */
	@Override
	public void deletefield(int fieldid) {
		logger.info("Deleting a template from db"); 

		fieldRepository.deleteById(fieldid);
	}

	/**
	 * @param fieldid - to get the field 
	 * @return Field- returns the field that matches the id
	 */
	@Override
	public Field getById(int fieldid) {
		logger.info("Getting field by Id's from db"); 

		return 	fieldRepository.findById(fieldid).get();
	}

	/**
	 * @return Field- to get all the fields
	 */
	@Override
	public List<Field> getAll() {
		logger.info("Getting all the vailabe fields from db"); 
		
		return fieldRepository.findAll();
	}

	/**
	 * @param templateid
	 * @return List<Field> - to get the fields by template id
	 */
	@Override
	public List<Field> getByTemplateid(int templateid) {
		logger.info("Getting the fields belongs to the template id: "+templateid +" from db"); 

		return fieldRepository.findBytemplateId(templateid);
	}

}
