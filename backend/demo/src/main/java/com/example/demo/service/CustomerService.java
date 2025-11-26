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
    
    // ========== CRUD OPERATIONS ==========
    
    // CREATE - Skapa ny kund
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    // READ - Hitta kund med ID
    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }
    
    // READ - Hitta kund med email
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
    
    // READ - Hitta kund med personnummer
    public Customer findByPersonalNumber(String personalNumber) {
        return customerRepository.findByPersonalNumber(personalNumber);
    }
    
    // UPDATE - Uppdatera befintlig kund
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer); // save() fungerar för både create och update
    }
    
    // DELETE - Ta bort kund med ID
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }
    
    // DELETE - Ta bort kund med email
    public void deleteByEmail(String email) {
        customerRepository.deleteByEmail(email);
    }
    
    // ========== SEARCH OPERATIONS ==========
    
    // SEARCH - Hitta kunder med skostorlek
    public List<Customer> findByShoeSize(int shoeSize) {
        return customerRepository.findByShoeSize(shoeSize);
    }
    
    // SEARCH - Sök efter förnamn (innehåller text)
    public List<Customer> searchByFirstName(String firstName) {
        return customerRepository.findByFirstNameContainingIgnoreCase(firstName);
    }
    
    // UTILITY - Kontrollera om kund existerar
    public boolean customerExists(String id) {
        return customerRepository.existsById(id);
    }
}