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
        try {
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
        } catch (Exception e) {
            System.err.println("Error en insertFlight: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Set<FlightResponseDTO> listAllFlights() {
        try {
            return flightRepository.findAll().stream()
                .map(FlightMapper::toResponseDTO)
                .collect(Collectors.toSet());
        } catch (Exception e) {
            System.err.println("Error en listAllFlights: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public FlightResponseDTO listFlightById(Long id) {
        try {
            Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight con ID " + id + " no encontrado"));

            return FlightMapper.toResponseDTO(flight);
        } catch (Exception e) {
            System.err.println("Error en listFlightById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public FlightResponseDTO updateById(Long id, FlightRequestDTO flightRequestDTO) {
        try {
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
        } catch (Exception e) {
            System.err.println("Error en updateById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (!flightRepository.existsById(id)) {
                throw new IllegalArgumentException("Flight con ID " + id + " no encontrado para eliminación");
            }
            flightRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error en deleteById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Set<FlightResponseDTO> findFlightsByClientId(Long clientId) {
        try {
            if (clientId == null) throw new IllegalArgumentException("clientId no puede ser nulo");
            return flightRepository.findFlightsByClientId(clientId).stream()
                .map(FlightMapper::toResponseDTO)
                .collect(java.util.stream.Collectors.toSet());
        } catch (Exception e) {
            System.err.println("Error en findFlightsByClientId para clientId " + clientId + ": " + e.getMessage());
            throw e;
        }
    }

}
