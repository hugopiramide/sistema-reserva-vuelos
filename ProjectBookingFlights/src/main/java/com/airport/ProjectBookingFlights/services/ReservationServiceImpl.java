package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IReservationService;
import com.airport.ProjectBookingFlights.model.dto.request.ReservationRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ReservationResponseDTO;
import com.airport.ProjectBookingFlights.repositories.IReservationRepository;
import com.airport.ProjectBookingFlights.repositories.IFlightRepository;
import com.airport.ProjectBookingFlights.repositories.IClientRepository;
import com.airport.ProjectBookingFlights.mappers.ReservationMapper;
import com.airport.ProjectBookingFlights.model.Reservation;
import com.airport.ProjectBookingFlights.model.Flight;
import com.airport.ProjectBookingFlights.model.Client;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements IReservationService {
    
    private IReservationRepository reservationRepository;
    private IFlightRepository flightRepository;
    private IClientRepository clientRepository;

    public ReservationServiceImpl(IReservationRepository reservationRepository, IFlightRepository flightRepository, IClientRepository clientRepository) {
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public ReservationResponseDTO insertReservation(ReservationRequestDTO reservationRequestDTO) {
        if (reservationRequestDTO == null) {
            throw new IllegalArgumentException("ReservationRequestDTO no puede ser nulo");
        }

        Flight flight = flightRepository.findById(reservationRequestDTO.getFlightId())
            .orElseThrow(() -> new IllegalArgumentException("Flight no encontrado"));

        Client client = clientRepository.findById(reservationRequestDTO.getClientId())
            .orElseThrow(() -> new IllegalArgumentException("Client no encontrado"));

        Reservation reservation = ReservationMapper.toEntity(flight, client, reservationRequestDTO);
        reservationRepository.save(reservation);

        return ReservationMapper.toResponseDTO(reservation);
    }

    @Override
    public Set<ReservationResponseDTO> listAllReservations() {
        return reservationRepository.findAll().stream()
            .map(ReservationMapper::toResponseDTO)
            .collect(Collectors.toSet());
    }

    @Override
    public ReservationResponseDTO listReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Reservation con ID " + id + " no encontrada"));

        return ReservationMapper.toResponseDTO(reservation);
    }

    @Override
    public ReservationResponseDTO updateById(Long id, ReservationRequestDTO reservationRequestDTO) {
        if (reservationRequestDTO == null) {
            throw new IllegalArgumentException("ReservationRequestDTO no puede ser nulo");
        }

        Reservation existing = reservationRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Reservation con id " + id + " no existe"));

        Flight flight = null;
        Client client = null;

        if (reservationRequestDTO.getFlightId() != null) {
            flight = flightRepository.findById(reservationRequestDTO.getFlightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight no encontrado"));
        }
        if (reservationRequestDTO.getClientId() != null) {
            client = clientRepository.findById(reservationRequestDTO.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client no encontrado"));
        }

        ReservationMapper.updateEntityFromDTO(existing, flight, client, reservationRequestDTO);

        Reservation updated = reservationRepository.save(existing);

        return ReservationMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new IllegalArgumentException("Reservation con ID " + id + " no encontrada para eliminación");
        }
        reservationRepository.deleteById(id);
    }
}
