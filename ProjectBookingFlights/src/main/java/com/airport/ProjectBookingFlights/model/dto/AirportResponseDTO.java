package com.airport.ProjectBookingFlights.model.dto;

public class AirportResponseDTO {

    private String name;
    private String location;
    private String country;

    public AirportResponseDTO(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AirportResponseDTO [name=" + name + ", location=" + location + ", country=" + country + "]";
    }
    
}
