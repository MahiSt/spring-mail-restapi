package com.mail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mail.model.Field;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Repository
public interface IFieldRepository extends JpaRepository<Field, Integer>{
	
	/**
	 * @param templateId
	 * @return List<Field>
	 */
	@Query(value = "Select * from field where template_id=?1" ,nativeQuery = true)
	List<Field> findBytemplateId(int templateId);
}
