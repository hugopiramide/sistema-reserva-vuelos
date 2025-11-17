package com.airport.ProjectBookingFlights.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long flight_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_airport")
    private Airport originAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_airport")
    private Airport destinationAirport;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;
    @Column(name = "arrivalTime", nullable = true)
    private LocalDateTime arrivalTime;
    @Column(name = "capacity", nullable = false, length = 4)
    private Integer capacity;
    @Column(name = "availableSeats", length = 4)
    private Integer availableSeats;
    
    @ManyToMany
    @JoinTable(
        name = "service_flight",
        joinColumns = @JoinColumn(name = "flight_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> services;

    public Flight(){
    }

    public Flight(Airport originAirport, Airport destinationAirport, LocalDateTime departureTime,
            LocalDateTime arrivalTime, Integer capacity, Integer availableSeats) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    @Override
    public String toString() {
        return "Flight [flight_id=" + flight_id + ", originAirport=" + originAirport + ", destinationAirport="
                + destinationAirport + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
                + ", capacity=" + capacity + ", availableSeats=" + availableSeats + "]";
    }
    
}
