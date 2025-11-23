package com.airport.ProjectBookingFlights.services.interfaces;

import java.util.Set;

import com.airport.ProjectBookingFlights.model.dto.request.FlightServiceRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightServiceResponseDTO;

public interface IFlightServiceService {

	public FlightServiceResponseDTO insertFlightService(FlightServiceRequestDTO flightServiceRequestDTO);

	public Set<FlightServiceResponseDTO> listAllFlightServices();

	public FlightServiceResponseDTO listFlightServiceById(Long id);
    
	public FlightServiceResponseDTO updateById(Long id, FlightServiceRequestDTO flightServiceRequestDTO);

	public void deleteById(Long id);

	public Set<FlightServiceResponseDTO> findServicesByFlightId(Long flightId);
}
