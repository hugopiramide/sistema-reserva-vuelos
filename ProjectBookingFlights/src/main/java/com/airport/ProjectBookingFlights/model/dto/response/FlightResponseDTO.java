package com.airport.ProjectBookingFlights.model.dto.response;

import java.time.LocalDateTime;

public class FlightResponseDTO {
    
    private String originAirport;
    private String destinationAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer capacity;
    private Integer availableSeats;

    public FlightResponseDTO(){  
    }
    
    public FlightResponseDTO(String originAirport, String destinationAirport, LocalDateTime departureTime,
            LocalDateTime arrivalTime, Integer capacity, Integer availableSeats) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
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

    @Override
    public String toString() {
        return "FlightResponseDTO [originAirport=" + originAirport + ", destinationAirport=" + destinationAirport
                + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", capacity=" + capacity
                + ", availableSeats=" + availableSeats + "]";
    }

}
