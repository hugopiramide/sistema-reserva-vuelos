package com.airport.ProjectBookingFlights.model.dto.request;


public class ReservationRequestDTO {
    
    private Long flightId;
    private Long clientId;

    public ReservationRequestDTO(){
        
    }

    public Long getFlightId() {
        return flightId;
    }
    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "ReservationRequestDTO [flightId=" + flightId + ", clientId=" + clientId + "]";
    }
    
}
