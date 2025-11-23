package com.airport.ProjectBookingFlights.model;

import java.util.HashSet;
import java.util.Set;

import com.airport.ProjectBookingFlights.model.vo.City;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airport_id;

    @Column(name = "name", length = 55)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "location", column = @Column(name = "location", length = 100)),
            @AttributeOverride(name = "country", column = @Column(name = "country", length = 55))
    })
    private City city;

    @OneToMany(mappedBy = "originAirport", orphanRemoval = true)
    private Set<Flight> originFlights = new HashSet<>();

    @OneToMany(mappedBy = "destinationAirport", orphanRemoval = true)
    private Set<Flight> destinationFlights = new HashSet<>();

    public Airport() {
    }

    public Airport(String name, City city) {
        this.name = name;
        this.city = city;
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

    public Set<Flight> getOriginFlights() {
        return originFlights;
    }

    public void setOriginFlights(Set<Flight> originFlights) {
        this.originFlights = originFlights;
    }

    public Set<Flight> getDestinationFlights() {
        return destinationFlights;
    }

    public void setDestinationFlights(Set<Flight> destinationFlights) {
        this.destinationFlights = destinationFlights;
    }

    public Long getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(Long airport_id) {
        this.airport_id = airport_id;
    }

    @Override
    public String toString() {
        return "Airport [airport_id=" + airport_id + ", name=" + name + ", city=" + city + ", originFlights="
                + originFlights + ", destinationFlights=" + destinationFlights + "]";
    }

}
