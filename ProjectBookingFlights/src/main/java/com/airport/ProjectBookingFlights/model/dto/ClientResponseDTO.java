package com.airport.ProjectBookingFlights.model.dto;

import java.util.Set;

public class ClientResponseDTO {
    
    private String name;
    private String firstName;
    private String email;

    public ClientResponseDTO(){

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClientResponseDTO [name=" + name + ", firstName=" + firstName + ", email=" + email + "]";
    }
    
}
