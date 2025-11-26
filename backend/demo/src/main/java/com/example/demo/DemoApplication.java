package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.MongoConnectionService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		// Start Spring Boot application
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		// Test MongoDB connection
		MongoConnectionService mongoService = context.getBean(MongoConnectionService.class);
		mongoService.testConnection();
		
	}

}
