package com.airport.ProjectBookingFlights.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.ProjectBookingFlights.model.dto.request.FlightServiceRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightServiceResponseDTO;
import com.airport.ProjectBookingFlights.services.interfaces.IFlightServiceService;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/flight-services")
public class FlightServiceController {

    private IFlightServiceService flightServiceService;

    public FlightServiceController(IFlightServiceService flightServiceService) {
        this.flightServiceService = flightServiceService;
    }

    @GetMapping
    public Set<FlightServiceResponseDTO> getAllFlightServices() {
        try {
            return flightServiceService.listAllFlightServices();
        } catch (Exception e) {
            System.err.println("Error al obtener todos los servicios de vuelo: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{id}")
    public FlightServiceResponseDTO getFlightServiceById(@PathVariable Long id) {
        try {
            return flightServiceService.listFlightServiceById(id);
        } catch (Exception e) {
            System.err.println("Error al obtener servicio de vuelo por id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/by-flight/{flightId}")
    public Set<FlightServiceResponseDTO> getServicesByFlight(@PathVariable Long flightId) {
        try {
            return flightServiceService.findServicesByFlightId(flightId);
        } catch (Exception e) {
            System.err.println("Error al obtener servicios para el vuelo " + flightId + ": " + e.getMessage());
            throw e;
        }
    }

    @PostMapping
    public FlightServiceResponseDTO postFlightService(@RequestBody FlightServiceRequestDTO flightServiceRequestDTO) {
        try {
            return flightServiceService.insertFlightService(flightServiceRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al crear servicio de vuelo: " + e.getMessage());
            throw e;
        }
    }

    @PutMapping("/{id}")
    public FlightServiceResponseDTO putFlightServiceById(@PathVariable Long id,
            @RequestBody FlightServiceRequestDTO flightServiceRequestDTO) {
        try {
            return flightServiceService.updateById(id, flightServiceRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al actualizar servicio de vuelo con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            flightServiceService.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar servicio de vuelo con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

}
