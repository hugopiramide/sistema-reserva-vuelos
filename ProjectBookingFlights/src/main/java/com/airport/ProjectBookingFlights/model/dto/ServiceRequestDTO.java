package com.airport.ProjectBookingFlights.model.dto;

public class ServiceRequestDTO {
    
    private String name;
    private String description;
    
    public ServiceRequestDTO() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ServiceRequestDTO [name=" + name + ", description=" + description + "]";
    }
    
}
