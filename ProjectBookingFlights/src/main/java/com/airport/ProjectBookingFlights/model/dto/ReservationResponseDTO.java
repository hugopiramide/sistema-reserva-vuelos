package com.airport.ProjectBookingFlights.model.dto;

import java.time.LocalDateTime;

public class ReservationResponseDTO {
    
    private Integer totalPassengers;
    private LocalDateTime bookingDate;
    private String status;
    private FlightResponseDTO flight;
    private ClientResponseDTO client;
    
    public ReservationResponseDTO(){
        
    }

    public Integer getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(Integer totalPassengers) {
        this.totalPassengers = totalPassengers;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FlightResponseDTO getFlight() {
        return flight;
    }

    public void setFlight(FlightResponseDTO flight) {
        this.flight = flight;
    }

    public ClientResponseDTO getClient() {
        return client;
    }

    public void setClient(ClientResponseDTO client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ReservationResponseDTO [totalPassengers=" + totalPassengers + ", bookingDate=" + bookingDate
                + ", status=" + status + ", flight=" + flight + ", client=" + client + "]";
    }

}
