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
        return flightService.listAllFlights();
    }

    @GetMapping("/{id}")
    public FlightResponseDTO getFlightById(@PathVariable Long id) {
        return flightService.listFlightById(id);
    }

    @PostMapping("/save")
    public FlightResponseDTO postFlight(@RequestBody FlightRequestDTO flightRequestDTO) {
        return flightService.insertFlight(flightRequestDTO);
    }

    @PutMapping("/save/{id}")
    public FlightResponseDTO putFlightById(@PathVariable Long id, @RequestBody FlightRequestDTO flightRequestDTO) {
        return flightService.updateById(id, flightRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        flightService.deleteById(id);
    }

}
