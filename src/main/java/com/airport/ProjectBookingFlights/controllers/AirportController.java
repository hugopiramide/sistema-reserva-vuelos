package com.airport.ProjectBookingFlights.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.ProjectBookingFlights.model.dto.request.AirportRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.AirportResponseDTO;
import com.airport.ProjectBookingFlights.services.interfaces.IAirportService;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private IAirportService airportService;

    public AirportController(IAirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public Set<AirportResponseDTO> getAllAirports() {
        try {
            return airportService.listAllAirports();
        } catch (Exception e) {
            System.err.println("Error al obtener todos los aeropuertos: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{id}")
    public AirportResponseDTO getAirportById(@PathVariable Long id) {
        try {
            return airportService.listAirportById(id);
        } catch (Exception e) {
            System.err.println("Error al obtener aeropuerto por id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{id}/flights/count")
    public int countFlightsByAirport(@PathVariable int id) {
        try {
            return airportService.countFlightsByAirportId(id);
        } catch (Exception e) {
            System.err.println("Error al contar vuelos para aeropuerto " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @PostMapping
    public AirportResponseDTO postAirport(@RequestBody AirportRequestDTO airportRequestDTO) {
        try {
            return airportService.insertAirport(airportRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al crear aeropuerto: " + e.getMessage());
            throw e;
        }
    }

    @PutMapping("/{id}")
    public AirportResponseDTO putAirportById(@PathVariable Long id, @RequestBody AirportRequestDTO airportRequestDTO) {
        try {
            return airportService.updateById(id, airportRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al actualizar aeropuerto con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            airportService.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar aeropuerto con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

}
