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
        return reservationService.listAllReservations();
    }

    @GetMapping("/{id}")
    public ReservationResponseDTO getReservationById(@PathVariable Long id) {
        return reservationService.listReservationById(id);
    }

    @PostMapping("/save")
    public ReservationResponseDTO postReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        return reservationService.insertReservation(reservationRequestDTO);
    }

    @PutMapping("/save/{id}")
    public ReservationResponseDTO putReservationById(@PathVariable Long id, @RequestBody ReservationRequestDTO reservationRequestDTO) {
        return reservationService.updateById(id, reservationRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        reservationService.deleteById(id);
    }

}
