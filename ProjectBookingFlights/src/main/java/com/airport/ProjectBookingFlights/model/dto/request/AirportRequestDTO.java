package com.airport.ProjectBookingFlights.model.dto.request;

public class AirportRequestDTO {
    
    private String name;
    private String location;
    private String country;
    
    public AirportRequestDTO(){
        
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
        return "AirportRequestDTO [name=" + name + ", location=" + location + ", country=" + country + "]";
    }
    
}
