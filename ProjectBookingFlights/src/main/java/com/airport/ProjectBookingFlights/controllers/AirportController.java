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
        return airportService.listAllAirports();
    }

    @GetMapping("/{id}")
    public AirportResponseDTO getAirportById(@PathVariable Long id) {
        return airportService.listAirportById(id);
    }

    @GetMapping("/{id}/flights/count")
    public Long countFlightsByAirport(@PathVariable Long id) {
        return airportService.countFlightsByAirportId(id);
    }

    @PostMapping("/save")
    public AirportResponseDTO postAirport(@RequestBody AirportRequestDTO airportRequestDTO) {
        return airportService.insertAirport(airportRequestDTO);
    }

    @PutMapping("/save/{id}")
    public AirportResponseDTO putAirportById(@PathVariable Long id, @RequestBody AirportRequestDTO airportRequestDTO) {
        return airportService.updateById(id, airportRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        airportService.deleteById(id);
    }

}
