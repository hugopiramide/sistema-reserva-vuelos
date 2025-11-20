package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IReservationService;
import com.airport.ProjectBookingFlights.model.dto.request.ReservationRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ReservationResponseDTO;
import com.airport.ProjectBookingFlights.repositories.IReservationRepository;

import java.util.Set;
import java.util.HashSet;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements IReservationService {
    
    private IReservationRepository reservationRepository;
    
    public ReservationServiceImpl(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationResponseDTO insertReservation(ReservationRequestDTO reservationRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public Set<ReservationResponseDTO> listAllReservations() {
        // TODO: Implement logic
        return new HashSet<>();
    }

    @Override
    public ReservationResponseDTO listReservationById(Long id) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public ReservationResponseDTO updateById(Long id, ReservationRequestDTO reservationRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO: Implement logic
    }
}
