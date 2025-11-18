package com.airport.ProjectBookingFlights.model.dto;

public class ClientRequestDTO {
    
    private String name;
    private String firstName;
    private String email;
    
    public ClientRequestDTO(){
        
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
        return "ClientRequestDTO [name=" + name + ", firstName=" + firstName + ", email=" + email + "]";
    }
    
}
