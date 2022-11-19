package com.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail.model.MailTemplate;


/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Repository
public interface ITemplateRepository extends JpaRepository<MailTemplate, Integer>{

}
