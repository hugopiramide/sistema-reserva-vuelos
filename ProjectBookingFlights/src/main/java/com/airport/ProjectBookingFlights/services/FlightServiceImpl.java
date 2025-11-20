package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IFlightService;
import com.airport.ProjectBookingFlights.model.dto.request.FlightRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightResponseDTO;
import com.airport.ProjectBookingFlights.repositories.IFlightRepository;
import com.airport.ProjectBookingFlights.repositories.IAirportRepository;
import com.airport.ProjectBookingFlights.mappers.FlightMapper;
import com.airport.ProjectBookingFlights.model.Flight;
import com.airport.ProjectBookingFlights.model.Airport;
import java.util.stream.Collectors;

import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements IFlightService {
    
    private IFlightRepository flightRepository;
    private IAirportRepository airportRepository;

    public FlightServiceImpl(IFlightRepository flightRepository, IAirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public FlightResponseDTO insertFlight(FlightRequestDTO flightRequestDTO) {
        if (flightRequestDTO == null) {
            throw new IllegalArgumentException("FlightRequestDTO no puede ser nulo");
        }

        Airport origin = airportRepository.findById(flightRequestDTO.getOriginAirportId())
            .orElseThrow(() -> new IllegalArgumentException("Origin airport no encontrado"));
        Airport destination = airportRepository.findById(flightRequestDTO.getDestinationAirportId())
            .orElseThrow(() -> new IllegalArgumentException("Destination airport no encontrado"));

        Flight flight = FlightMapper.toEntity(origin, destination, flightRequestDTO);
        flightRepository.save(flight);

        return FlightMapper.toResponseDTO(flight);
    }

    @Override
    public Set<FlightResponseDTO> listAllFlights() {
        return flightRepository.findAll().stream()
            .map(FlightMapper::toResponseDTO)
            .collect(Collectors.toSet());
    }

    @Override
    public FlightResponseDTO listFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Flight con ID " + id + " no encontrado"));

        return FlightMapper.toResponseDTO(flight);
    }

    @Override
    public FlightResponseDTO updateById(Long id, FlightRequestDTO flightRequestDTO) {
        if (flightRequestDTO == null) {
            throw new IllegalArgumentException("FlightRequestDTO no puede ser nulo");
        }

        Flight existing = flightRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Flight con id " + id + " no existe"));

        Airport origin = null;
        Airport destination = null;

        if (flightRequestDTO.getOriginAirportId() != null) {
            origin = airportRepository.findById(flightRequestDTO.getOriginAirportId())
                .orElseThrow(() -> new IllegalArgumentException("Origin airport no encontrado"));
        }
        if (flightRequestDTO.getDestinationAirportId() != null) {
            destination = airportRepository.findById(flightRequestDTO.getDestinationAirportId())
                .orElseThrow(() -> new IllegalArgumentException("Destination airport no encontrado"));
        }

        FlightMapper.updateEntityFromDTO(existing, origin, destination, flightRequestDTO);

        Flight updated = flightRepository.save(existing);

        return FlightMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new IllegalArgumentException("Flight con ID " + id + " no encontrado para eliminación");
        }
        flightRepository.deleteById(id);
    }
}
