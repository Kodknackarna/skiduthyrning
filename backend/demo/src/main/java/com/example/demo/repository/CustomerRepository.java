package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    
    // CRUD - Custom query methods (MongoRepository provides basic CRUD automatically)
    
    // READ operations
    Customer findByEmail(String email);
    Customer findByPersonalNumber(String personalNumber);
    List<Customer> findByShoeSize(int shoeSize);
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    
    // SEARCH operations
    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
    List<Customer> findByLastNameContainingIgnoreCase(String lastName);
    
    // DELETE operations  
    void deleteByEmail(String email);
    void deleteByPersonalNumber(String personalNumber);
}