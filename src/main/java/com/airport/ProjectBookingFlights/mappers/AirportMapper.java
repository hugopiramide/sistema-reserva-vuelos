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

    public static void updateEntityFromDTO(Airport existingAirport, AirportRequestDTO dto) {
            if (existingAirport == null || dto == null) {
                return;
            }

            if( dto.getName() != null ){
                existingAirport.setName(dto.getName());
            }

            if( dto.getCountry() != null || dto.getLocation() != null ){
                City updatedCity = new City(dto.getLocation(),dto.getCountry());
                existingAirport.setCity(updatedCity);
            }

        }
    
}
