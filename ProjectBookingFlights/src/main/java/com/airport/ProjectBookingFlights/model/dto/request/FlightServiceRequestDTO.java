package com.airport.ProjectBookingFlights.model.dto.request;

public class FlightServiceRequestDTO {
    
    private String name;
    private String description;
    
    public FlightServiceRequestDTO() {
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
