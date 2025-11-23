package com.airport.ProjectBookingFlights.model.vo;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class City {
    
    private final String location;
    private final String country;
    
    public City(){
        this.location = null;
        this.country = null;
    }
    
    public City(String location, String country){
        this.location = location;
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location,country);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        City other = (City) obj;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "City [location=" + location + ", country=" + country + "]";
    }
    
}
