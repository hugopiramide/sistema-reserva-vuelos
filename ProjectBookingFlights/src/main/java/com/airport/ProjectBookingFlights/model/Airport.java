package com.airport.ProjectBookingFlights.model;

import com.airport.ProjectBookingFlights.model.vo.City;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long airpor_id;

    @Column(name = "name", length = 55)
    private String name;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride( name = "location", column = @Column(name = "location", length = 100)),
        @AttributeOverride( name = "country", column = @Column(name = "country", length = 55))
    })
    private City city;

    public Airport(){
    }

    public Airport(Long airpor_id, String name, City city) {
        this.airpor_id = airpor_id;
        this.name = name;
        this.city = city;
    }

    public Long getAirpor_id() {
        return airpor_id;
    }

    public void setAirpor_id(Long airpor_id) {
        this.airpor_id = airpor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    

}
