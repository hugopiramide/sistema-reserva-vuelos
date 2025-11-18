package com.airport.ProjectBookingFlights.model.dto;

public class ServiceResponseDTO {
    
    private String name;
    private String description;
    
    public ServiceResponseDTO() {
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
        return "ServiceResponseDTO [name=" + name + ", description=" + description + "]";
    }
    
}
