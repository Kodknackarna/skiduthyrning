package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Kunder")
public class Customer {
    
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String personalNumber;
    private int shoeSize;
    private int height;
    private int weight;
    private String phoneNumber;
    
    // Default constructor
    public Customer() {}
    
    // Constructor with all fields
    public Customer(String firstName, String lastName, String email, String personalNumber, 
                   int shoeSize, int height, int weight, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalNumber = personalNumber;
        this.shoeSize = shoeSize;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPersonalNumber() { return personalNumber; }
    public void setPersonalNumber(String personalNumber) { this.personalNumber = personalNumber; }
    
    public int getShoeSize() { return shoeSize; }
    public void setShoeSize(int shoeSize) { this.shoeSize = shoeSize; }
    
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", shoeSize=" + shoeSize +
                ", height=" + height +
                ", weight=" + weight +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}