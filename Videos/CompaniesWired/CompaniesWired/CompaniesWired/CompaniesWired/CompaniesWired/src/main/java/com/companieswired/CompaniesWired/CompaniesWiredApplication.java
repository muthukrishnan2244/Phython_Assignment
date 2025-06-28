package com.companieswired.CompaniesWired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CompaniesWiredApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CompaniesWiredApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
	return application.sources(CompaniesWiredApplication.class);  
	}   

}
