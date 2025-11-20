package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IAirportService;
import com.airport.ProjectBookingFlights.model.dto.request.AirportRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.AirportResponseDTO;
import java.util.Set;
import java.util.HashSet;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements IAirportService {
    @Override
    public AirportResponseDTO insertAirport(AirportRequestDTO airportRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public Set<AirportResponseDTO> listAllAirports() {
        // TODO: Implement logic
        return new HashSet<>();
    }

    @Override
    public AirportResponseDTO listAirportById(Long id) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public AirportResponseDTO updateById(Long id, AirportRequestDTO airportRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO: Implement logic
    }
}
