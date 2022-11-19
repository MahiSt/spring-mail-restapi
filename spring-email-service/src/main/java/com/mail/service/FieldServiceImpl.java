package com.mail.service;

import java.util.List;

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
	
	@Autowired
	IFieldRepository fieldRepository;

	/**
	 * @param field - the field to be added
	 */
	@Override
	public void addField(Field field) {
		fieldRepository.save(field);
	}

	/**
	 * @param field - updating already existing field
	 */
	@Override
	public void updatefield(Field field) {
		fieldRepository.save(field);
		
	}

	/**
	 * @param fieldid - to delete the field
	 */
	@Override
	public void deletefield(int fieldid) {
		fieldRepository.deleteById(fieldid);
		
	}

	/**
	 * @param fieldid - to get the field 
	 * @return Field- returns the field that matches the id
	 */
	@Override
	public Field getById(int fieldid) {
		return 	fieldRepository.findById(fieldid).get();
	}

	/**
	 * @return Field- to get all the fields
	 */
	@Override
	public List<Field> getAll() {
		return fieldRepository.findAll();
	}

	/**
	 * @param templateid
	 * @return List<Field> - to get the fields by template id
	 */
	@Override
	public List<Field> getByTemplateid(int templateid) {
		return fieldRepository.findBytemplateId(templateid);
	}

}
