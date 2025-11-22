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
        Airport airport = AirportMapper.toEntity(airportRequestDTO);
        if(airport == null){
            throw new IllegalArgumentException("El aeropuerto no puede ser nulo");
        }
        airportRepository.save(airport);

        AirportResponseDTO responseDTO = AirportMapper.toResponseDTO(airport);
        return responseDTO;
    }

    @Override
    public Set<AirportResponseDTO> listAllAirports() {
        return airportRepository.findAll().stream()
            .map(AirportMapper::toResponseDTO)
            .collect(Collectors.toSet());
    }

    @Override
    public AirportResponseDTO listAirportById(Long id) {
        Airport airport = airportRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Aeropuerto con ID " + id + " no encontrado"));

        return AirportMapper.toResponseDTO(airport);
    }

    @Override
    public AirportResponseDTO updateById(Long id, AirportRequestDTO airportRequestDTO) {
        
        if (airportRequestDTO == null) {
            throw new IllegalArgumentException("El AirportRequestDTO no puede ser nulo");
        }
        
        Airport existingAirport = airportRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("El aeropuerto con id " + id + " no existe"));

        AirportMapper.updateEntityFromDTO(existingAirport, airportRequestDTO); 

        Airport updatedAirport = airportRepository.save(existingAirport);

        return AirportMapper.toResponseDTO(updatedAirport);
    }

    @Override
    public void deleteById(Long id) {
        if (!airportRepository.existsById(id)) {
            throw new IllegalArgumentException("Aeropuerto con ID " + id + " no encontrado para eliminación");
        }
        airportRepository.deleteById(id);
    }

    @Override
    public Long countFlightsByAirportId(Long airportId) {
        if (airportId == null) throw new IllegalArgumentException("airportId no puede ser nulo");
        return airportRepository.countFlightsByAirportId(airportId);
    }

}
