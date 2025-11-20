package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IFlightServiceService;
import com.airport.ProjectBookingFlights.model.dto.request.FlightServiceRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightServiceResponseDTO;
import java.util.Set;
import java.util.HashSet;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceServiceImpl implements IFlightServiceService {
    @Override
    public FlightServiceResponseDTO insertFlightService(FlightServiceRequestDTO flightServiceRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public Set<FlightServiceResponseDTO> listAllFlightServices() {
        // TODO: Implement logic
        return new HashSet<>();
    }

    @Override
    public FlightServiceResponseDTO listFlightServiceById(Long id) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public FlightServiceResponseDTO updateById(Long id, FlightServiceRequestDTO flightServiceRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO: Implement logic
    }
}
