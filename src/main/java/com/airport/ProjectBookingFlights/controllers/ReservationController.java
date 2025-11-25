package com.airport.ProjectBookingFlights.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.ProjectBookingFlights.model.dto.request.ReservationRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ReservationResponseDTO;
import com.airport.ProjectBookingFlights.services.interfaces.IReservationService;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public Set<ReservationResponseDTO> getAllReservations() {
        try {
            return reservationService.listAllReservations();
        } catch (Exception e) {
            System.err.println("Error al obtener todas las reservaciones: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ReservationResponseDTO getReservationById(@PathVariable Long id) {
        try {
            return reservationService.listReservationById(id);
        } catch (Exception e) {
            System.err.println("Error al obtener reservación por id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/by-airport/{airportId}")
    public Set<ReservationResponseDTO> getReservationsByAirport(@PathVariable Long airportId) {
        try {
            return reservationService.findByAirportId(airportId);
        } catch (Exception e) {
            System.err.println("Error al obtener reservaciones para aeropuerto " + airportId + ": " + e.getMessage());
            throw e;
        }
    }

    @PostMapping
    public ReservationResponseDTO postReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        try {
            return reservationService.insertReservation(reservationRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al crear reservación: " + e.getMessage());
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ReservationResponseDTO putReservationById(@PathVariable Long id,
            @RequestBody ReservationRequestDTO reservationRequestDTO) {
        try {
            return reservationService.updateById(id, reservationRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al actualizar reservación con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            reservationService.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar reservación con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

}
