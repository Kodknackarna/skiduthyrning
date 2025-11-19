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
		
		// Använd EN scanner för hela programmet
		Scanner scanner = new Scanner(System.in);
		CustomerService customerService = context.getBean(CustomerService.class);
		
		// search customer by email
		System.out.println("Ange kundens email för att söka:");
		String email = scanner.nextLine();
		Customer customer = customerService.findByEmail(email);
		if (customer != null) {
			System.out.println("Kund hittad: " + customer.getFirstName() + " " + customer.getLastName());
		} else {
			System.out.println("Ingen kund hittades med email: " + email);
		}

		// search by personal number
		System.out.println("\nAnge kundens personnummer för att söka:");
		String personalNumber = scanner.nextLine();
		Customer customerByPN = customerService.findByPersonalNumber(personalNumber);
		if (customerByPN != null) {
			System.out.println("Kund hittad: " + customerByPN.getFirstName() + " " + customerByPN.getLastName());
		} else {
			System.out.println("Ingen kund hittades med personnummer: " + personalNumber);
		}

		// delete by email
		System.out.println("\nAnge kundens email för att radera:");
		String emailToDelete = scanner.nextLine();
		customerService.deleteByEmail(emailToDelete);
		System.out.println("Kund med email " + emailToDelete + " har raderats (om den fanns).");
		
		// add new customer
		System.out.println("\nLägg till en ny kund.");
		System.out.print("Förnamn: ");
		String firstName = scanner.nextLine();
		System.out.print("Efternamn: ");
		String lastName = scanner.nextLine();
		System.out.print("Email: ");
		String newEmail = scanner.nextLine();
		System.out.print("Personnummer: ");
		String newPersonalNumber = scanner.nextLine();
		System.out.print("Skostorlek: ");
		int shoeSize = Integer.parseInt(scanner.nextLine());
		System.out.print("Längd (cm): ");
		int height = Integer.parseInt(scanner.nextLine());
		System.out.print("Vikt (kg): ");
		int weight = Integer.parseInt(scanner.nextLine());
		System.out.print("Telefonnummer: ");
		String phoneNumber = scanner.nextLine();
		Customer newCustomer = new Customer(firstName, lastName, newEmail, newPersonalNumber, 
				shoeSize, height, weight, phoneNumber);
		customerService.createCustomer(newCustomer);
		System.out.println("Ny kund tillagd: " + firstName + " " + lastName);
		
		
		// update existing customer
		System.out.println("\nUppdatera kund.");
		System.out.print("Ange email för kunden som ska uppdateras: ");
		String emailToUpdate = scanner.nextLine();
		Customer customerToUpdate = customerService.findByEmail(emailToUpdate);
		if (customerToUpdate != null) {
			System.out.print("Nytt telefonnummer: ");
			String newPhoneNumber = scanner.nextLine();
			customerToUpdate.setPhoneNumber(newPhoneNumber);
			customerService.updateCustomer(customerToUpdate);
			System.out.println("Kund uppdaterad: " + customerToUpdate.getFirstName() + " " + customerToUpdate.getLastName());
		} else {
			System.out.println("Ingen kund hittades med email: " + emailToUpdate);
		}

		// Stäng scanner när vi är klara
		scanner.close();

		// Visa alla kunder från MongoDB
		customerService.printAllCustomers();
		
	}

}
