package com.airport.ProjectBookingFlights.mappers;

import com.airport.ProjectBookingFlights.model.FlightService;
import com.airport.ProjectBookingFlights.model.dto.request.FlightServiceRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightServiceResponseDTO;

public class FlightServiceMapper {
    
    public static FlightService toEntity(FlightServiceRequestDTO flightServiceRequestDTO){
        FlightService flightService = new FlightService();
        flightService.setName(flightServiceRequestDTO.getName());
        flightService.setDescription(flightServiceRequestDTO.getDescription());
        return flightService;
    }
    
    public static FlightServiceResponseDTO toResponse(FlightService flightService){
        FlightServiceResponseDTO dto = new FlightServiceResponseDTO();
        dto.setName(flightService.getName());
        dto.setDescription(flightService.getDescription());
        return dto;
    }
}
