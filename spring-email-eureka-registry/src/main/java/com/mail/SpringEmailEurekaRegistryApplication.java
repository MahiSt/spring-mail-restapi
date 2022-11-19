package com.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringEmailEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailEurekaRegistryApplication.class, args);
	}

}
