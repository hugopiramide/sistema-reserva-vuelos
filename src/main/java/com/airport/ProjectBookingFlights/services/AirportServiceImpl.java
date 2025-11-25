package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IAirportService;

import com.airport.ProjectBookingFlights.mappers.AirportMapper;
import com.airport.ProjectBookingFlights.model.Airport;
import com.airport.ProjectBookingFlights.model.dto.request.AirportRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.AirportResponseDTO;
import com.airport.ProjectBookingFlights.repositories.IAirportRepository;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements IAirportService {

    private IAirportRepository airportRepository;

    public AirportServiceImpl(IAirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public AirportResponseDTO insertAirport(AirportRequestDTO airportRequestDTO) {
        try {
            Airport airport = AirportMapper.toEntity(airportRequestDTO);
            if (airport == null) {
                throw new IllegalArgumentException("El aeropuerto no puede ser nulo");
            }
            airportRepository.save(airport);

            AirportResponseDTO responseDTO = AirportMapper.toResponseDTO(airport);
            return responseDTO;
        } catch (Exception e) {
            System.err.println("Error en insertAirport: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Set<AirportResponseDTO> listAllAirports() {
        try {
            return airportRepository.findAll().stream()
                    .map(AirportMapper::toResponseDTO)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            System.err.println("Error en listAllAirports: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AirportResponseDTO listAirportById(Long id) {
        try {
            Airport airport = airportRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Aeropuerto con ID " + id + " no encontrado"));

            return AirportMapper.toResponseDTO(airport);
        } catch (Exception e) {
            System.err.println("Error en listAirportById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AirportResponseDTO updateById(Long id, AirportRequestDTO airportRequestDTO) {
        try {
            if (airportRequestDTO == null) {
                throw new IllegalArgumentException("El AirportRequestDTO no puede ser nulo");
            }

            Airport existingAirport = airportRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("El aeropuerto con id " + id + " no existe"));

            AirportMapper.updateEntityFromDTO(existingAirport, airportRequestDTO);

            Airport updatedAirport = airportRepository.save(existingAirport);

            return AirportMapper.toResponseDTO(updatedAirport);
        } catch (Exception e) {
            System.err.println("Error en updateById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (!airportRepository.existsById(id)) {
                throw new IllegalArgumentException("Aeropuerto con ID " + id + " no encontrado para eliminación");
            }
            airportRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error en deleteById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public int countFlightsByAirportId(int airportId) {
        try {
            return airportRepository.countFlightsByAirportId(airportId);
        } catch (Exception e) {
            System.err.println("Error en countFlightsByAirportId para airportId " + airportId + ": " + e.getMessage());
            throw e;
        }
    }

}
