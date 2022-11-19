package com.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author SENTHILKUMARMAHESWARAN
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class SpringEmailConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailConfigServerApplication.class, args);
	}

}
