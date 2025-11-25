package com.airport.ProjectBookingFlights.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.ProjectBookingFlights.model.dto.request.FlightRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightResponseDTO;
import com.airport.ProjectBookingFlights.services.interfaces.IFlightService;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private IFlightService flightService;

    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public Set<FlightResponseDTO> getAllFlights() {
        try {
            return flightService.listAllFlights();
        } catch (Exception e) {
            System.err.println("Error al obtener todos los vuelos: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{id}")
    public FlightResponseDTO getFlightById(@PathVariable Long id) {
        try {
            return flightService.listFlightById(id);
        } catch (Exception e) {
            System.err.println("Error al obtener vuelo por id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/by-client/{clientId}")
    public Set<FlightResponseDTO> getFlightsByClient(@PathVariable Long clientId) {
        try {
            return flightService.findFlightsByClientId(clientId);
        } catch (Exception e) {
            System.err.println("Error al obtener vuelos del cliente " + clientId + ": " + e.getMessage());
            throw e;
        }
    }

    @PostMapping
    public FlightResponseDTO postFlight(@RequestBody FlightRequestDTO flightRequestDTO) {
        try {
            return flightService.insertFlight(flightRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al crear vuelo: " + e.getMessage());
            throw e;
        }
    }

    @PutMapping("/{id}")
    public FlightResponseDTO putFlightById(@PathVariable Long id, @RequestBody FlightRequestDTO flightRequestDTO) {
        try {
            return flightService.updateById(id, flightRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al actualizar vuelo con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            flightService.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar vuelo con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

}
