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
        return flightServiceService.listAllFlightServices();
    }

    @GetMapping("/{id}")
    public FlightServiceResponseDTO getFlightServiceById(@PathVariable Long id) {
        return flightServiceService.listFlightServiceById(id);
    }

    @PostMapping("/save")
    public FlightServiceResponseDTO postFlightService(@RequestBody FlightServiceRequestDTO flightServiceRequestDTO) {
        return flightServiceService.insertFlightService(flightServiceRequestDTO);
    }

    @PutMapping("/save/{id}")
    public FlightServiceResponseDTO putFlightServiceById(@PathVariable Long id, @RequestBody FlightServiceRequestDTO flightServiceRequestDTO) {
        return flightServiceService.updateById(id, flightServiceRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        flightServiceService.deleteById(id);
    }

}
