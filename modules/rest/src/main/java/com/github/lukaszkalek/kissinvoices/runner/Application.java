package com.github.lukaszkalek.kissinvoices.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import com.github.lukaszkalek.kissinvoices.rest.config.RestConfig;
import com.github.lukaszkalek.kissinvoices.service.config.ServiceConfig;

@EnableAutoConfiguration
@Import({RestConfig.class, ServiceConfig.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
