package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    // Hämta alla kunder från MongoDB
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    // Skriv ut alla kunder i konsolen
    public void printAllCustomers() {
        List<Customer> customers = getAllCustomers();
        
        System.out.println("\n========== ALLA KUNDER ==========");
        System.out.println("Antal kunder: " + customers.size());
        System.out.println("==================================");
        
        if (customers.isEmpty()) {
            System.out.println("Inga kunder hittades i databasen.");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println((i + 1) + ". " + customer.getFirstName() + " " + customer.getLastName());
                System.out.println("   Email: " + customer.getEmail());
                System.out.println("   Telefon: " + customer.getPhoneNumber());
                System.out.println("   Skostorlek: " + customer.getShoeSize());
                System.out.println("   Längd: " + customer.getHeight() + " cm, Vikt: " + customer.getWeight() + " kg");
                System.out.println("   ---");
            }
        }
        System.out.println("==================================\n");
    }
    
    
   
}