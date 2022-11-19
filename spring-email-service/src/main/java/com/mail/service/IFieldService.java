package com.mail.service;

import java.util.List;

import com.mail.model.Field;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
public interface IFieldService {
	void addField(Field field);
	void updatefield(Field field);
	void deletefield(int fieldid);
	Field getById(int fieldid);
	
	List<Field> getAll();
	List<Field> getByTemplateid(int templateid);
}
