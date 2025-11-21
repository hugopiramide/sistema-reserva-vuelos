package com.airport.ProjectBookingFlights.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.airport.ProjectBookingFlights.model.vo.Passengers;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flight_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_airport_id")
    private Airport originAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_airport_id")
    private Airport destinationAirport;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;
    @Column(name = "arrival_time", nullable = true)
    private LocalDateTime arrivalTime;

    @Embedded
    @AttributeOverride(name = "total", column = @Column(name = "passengers", length = 4))
    private Passengers passengers;

    @Column(name = "available_seats", length = 4)
    private Integer availableSeats;

    @ManyToMany
    @JoinTable(name = "service_flight", joinColumns = @JoinColumn(name = "flight_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<FlightService> flightServices = new HashSet<>();

    @OneToMany(mappedBy = "flight", orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();

    public Flight() {
    }

    public Flight(Airport originAirport, Airport destinationAirport, LocalDateTime departureTime,
            LocalDateTime arrivalTime, Passengers passengers, Integer availableSeats) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.passengers = passengers;
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

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
        this.passengers = passengers;
    }

    public Set<FlightService> getFlightServices() {
        return flightServices;
    }

    public void setFlightServices(Set<FlightService> flightServices) {
        this.flightServices = flightServices;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
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
                + ", passengers=" + passengers + ", availableSeats=" + availableSeats + ", flightServices="
                + flightServices + ", reservations=" + reservations + "]";
    }

}
