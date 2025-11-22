package com.airport.ProjectBookingFlights.services.interfaces;

import java.util.Set;

import com.airport.ProjectBookingFlights.model.dto.request.AirportRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.AirportResponseDTO;

public interface IAirportService {
    
    public AirportResponseDTO insertAirport(AirportRequestDTO airportRequestDTO);
    
    public Set<AirportResponseDTO> listAllAirports();
    
    public AirportResponseDTO listAirportById(Long id);
    
    public AirportResponseDTO updateById(Long id, AirportRequestDTO airportRequestDTO);

    public void deleteById(Long id);

    public Long countFlightsByAirportId(Long airportId);
}
