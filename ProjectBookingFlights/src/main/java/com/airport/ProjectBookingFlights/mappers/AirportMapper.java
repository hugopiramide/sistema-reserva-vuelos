package com.airport.ProjectBookingFlights.mappers;

import com.airport.ProjectBookingFlights.model.Airport;
import com.airport.ProjectBookingFlights.model.dto.request.AirportRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.AirportResponseDTO;
import com.airport.ProjectBookingFlights.model.vo.City;

public class AirportMapper {
    
    public static Airport toEntity(AirportRequestDTO airportRequestDTO){
        Airport airport = new Airport();
        airport.setName(airportRequestDTO.getName());
        airport.setCity(new City(airportRequestDTO.getLocation(),airportRequestDTO.getCountry()));
        return airport;
    }
    
    public static AirportResponseDTO toResponseDTO(Airport airport){
        AirportResponseDTO dto = new AirportResponseDTO();
        dto.setName(airport.getName());
        dto.setCountry(airport.getCity().getCountry());
        dto.setLocation(airport.getCity().getLocation());
        return dto;
    }
    
}
