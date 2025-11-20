package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IFlightService;
import com.airport.ProjectBookingFlights.model.dto.request.FlightRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightResponseDTO;
import java.util.Set;
import java.util.HashSet;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements IFlightService {
    @Override
    public FlightResponseDTO insertFlight(FlightRequestDTO flightRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public Set<FlightResponseDTO> listAllFlights() {
        // TODO: Implement logic
        return new HashSet<>();
    }

    @Override
    public FlightResponseDTO listFlightById(Long id) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public FlightResponseDTO updateById(Long id, FlightRequestDTO flightRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO: Implement logic
    }
}
