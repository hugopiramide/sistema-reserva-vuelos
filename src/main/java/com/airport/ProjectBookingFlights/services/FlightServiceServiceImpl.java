package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IFlightServiceService;
import com.airport.ProjectBookingFlights.model.dto.request.FlightServiceRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightServiceResponseDTO;
import com.airport.ProjectBookingFlights.mappers.FlightServiceMapper;
import com.airport.ProjectBookingFlights.model.FlightService;
import com.airport.ProjectBookingFlights.repositories.IFlightServiceRepository;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceServiceImpl implements IFlightServiceService {

    private IFlightServiceRepository flightServiceRepository;
    
    public FlightServiceServiceImpl(IFlightServiceRepository flightServiceRepository) {
        this.flightServiceRepository = flightServiceRepository;
    }

    @Override
    public FlightServiceResponseDTO insertFlightService(FlightServiceRequestDTO flightServiceRequestDTO) {
        try {
            if (flightServiceRequestDTO == null) {
                throw new IllegalArgumentException("FlightServiceRequestDTO no puede ser nulo");
            }

            FlightService flightService = FlightServiceMapper.toEntity(flightServiceRequestDTO);
            flightServiceRepository.save(flightService);

            return FlightServiceMapper.toResponse(flightService);
        } catch (Exception e) {
            System.err.println("Error en insertFlightService: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Set<FlightServiceResponseDTO> listAllFlightServices() {
        try {
            return flightServiceRepository.findAll().stream()
                .map(FlightServiceMapper::toResponse)
                .collect(Collectors.toSet());
        } catch (Exception e) {
            System.err.println("Error en listAllFlightServices: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public FlightServiceResponseDTO listFlightServiceById(Long id) {
        try {
            FlightService fs = flightServiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FlightService con ID " + id + " no encontrado"));

            return FlightServiceMapper.toResponse(fs);
        } catch (Exception e) {
            System.err.println("Error en listFlightServiceById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public FlightServiceResponseDTO updateById(Long id, FlightServiceRequestDTO flightServiceRequestDTO) {
        try {
            if (flightServiceRequestDTO == null) {
                throw new IllegalArgumentException("FlightServiceRequestDTO no puede ser nulo");
            }

            FlightService existing = flightServiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FlightService con id " + id + " no existe"));

            FlightServiceMapper.updateEntityFromDTO(existing, flightServiceRequestDTO);

            FlightService updated = flightServiceRepository.save(existing);

            return FlightServiceMapper.toResponse(updated);
        } catch (Exception e) {
            System.err.println("Error en updateById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (!flightServiceRepository.existsById(id)) {
                throw new IllegalArgumentException("FlightService con ID " + id + " no encontrado para eliminación");
            }
            flightServiceRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error en deleteById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Set<FlightServiceResponseDTO> findServicesByFlightId(Long flightId) {
        try {
            if (flightId == null) throw new IllegalArgumentException("flightId no puede ser nulo");
            return flightServiceRepository.findServicesByFlightId(flightId).stream()
                .map(FlightServiceMapper::toResponse)
                .collect(java.util.stream.Collectors.toSet());
        } catch (Exception e) {
            System.err.println("Error en findServicesByFlightId para flightId " + flightId + ": " + e.getMessage());
            throw e;
        }
    }

}
