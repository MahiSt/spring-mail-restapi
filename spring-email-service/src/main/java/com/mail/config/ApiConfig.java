package com.mail.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;


/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@Configuration
public class ApiConfig {

	private Logger logger = LoggerFactory.getLogger(ApiConfig.class);
	
	/**
	 * @return FreeMarkerConfigurationFactoryBean 
	 * 
	 * DESC - Configuring FreeMarker with the default pat for loading templates
	 */
	@Primary
	@Bean
	public FreeMarkerConfigurationFactoryBean factoryBean() {
		logger.info("Coniguring the freemarker template...");
		FreeMarkerConfigurationFactoryBean bean=new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:/templates");
		
		logger.info("Conigured the freemarker template...");
		return bean;
	}
}
