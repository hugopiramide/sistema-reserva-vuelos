package com.airport.ProjectBookingFlights.model.dto.request;

import java.time.LocalDateTime;

public class FlightRequestDTO {
    
    private Long originAirportId;
    private Long destinationAirportId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer capacity;

    public FlightRequestDTO(){
    }

    public Long getOriginAirportId() {
        return originAirportId;
    }
    public void setOriginAirportId(Long originAirportId) {
        this.originAirportId = originAirportId;
    }
    public Long getDestinationAirportId() {
        return destinationAirportId;
    }
    public void setDestinationAirportId(Long destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
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

    @Override
    public String toString() {
        return "FlightRequestDTO [originAirportId=" + originAirportId + ", destinationAirportId=" + destinationAirportId
                + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", capacity=" + capacity + "]";
    }

}
