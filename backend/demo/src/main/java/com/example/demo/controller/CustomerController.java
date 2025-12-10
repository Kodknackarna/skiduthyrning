package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*") // Tillåt begäranden från frontend
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    // GET - Hämta alla kunder från MongoDB
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // POST - Skapa ny kund
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer created = customerService.createCustomer(customer);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // DELETE - Ta bort kund med ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable String id) {
        if (!customerService.customerExists(id)) {
            return ResponseEntity.notFound().build();
        }
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE - Ta bort kund med email (exempel med query-param)
    @DeleteMapping("/by-email")
    public ResponseEntity<Void> deleteByEmail(@RequestParam String email) {
        Customer existing = customerService.findByEmail(email);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        customerService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
