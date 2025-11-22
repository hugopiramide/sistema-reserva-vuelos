package com.airport.ProjectBookingFlights.services.interfaces;

import java.util.Set;

import com.airport.ProjectBookingFlights.model.dto.request.FlightRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightResponseDTO;

public interface IFlightService {

	public FlightResponseDTO insertFlight(FlightRequestDTO flightRequestDTO);
    
	public Set<FlightResponseDTO> listAllFlights();

	public FlightResponseDTO listFlightById(Long id);

	public FlightResponseDTO updateById(Long id, FlightRequestDTO flightRequestDTO);

	public void deleteById(Long id);

	public Set<FlightResponseDTO> findFlightsByClientId(Long clientId);
}
