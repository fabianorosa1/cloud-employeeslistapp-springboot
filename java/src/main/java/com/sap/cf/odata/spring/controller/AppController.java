package com.sap.cf.odata.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.sap.cf.odata.spring.config.CloudConfig;

/**
 * 
 * @author fabiano.rosa
 *
 */
@SpringBootApplication(scanBasePackages = {"com.sap.cf.odata.spring"})
public class AppController extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);
	
	// Main method gives control to Spring by invoking run on Spring Application.
	// This enables Spring to Bootstrap the application
	public static void main(String[] args) {
		logger.info(">>>Enter main!!!!!");
		
		SpringApplication.run(AppController.class, args);

	}

	// This method adds Configuration class for Spring Application Context builder
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		logger.info(">>>Enter configure!!!!!");
		
		return builder.sources(AppController.class, CloudConfig.class);
	}
}
