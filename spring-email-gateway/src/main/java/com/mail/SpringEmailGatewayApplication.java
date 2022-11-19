package com.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class SpringEmailGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailGatewayApplication.class, args);
	}

}
