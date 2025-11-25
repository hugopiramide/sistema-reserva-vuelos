package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IReservationService;
import com.airport.ProjectBookingFlights.model.dto.request.ReservationRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ReservationResponseDTO;
import com.airport.ProjectBookingFlights.repositories.IReservationRepository;
import java.util.stream.Collectors;
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
        try {
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
        } catch (Exception e) {
            System.err.println("Error en insertReservation: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Set<ReservationResponseDTO> listAllReservations() {
        try {
            return reservationRepository.findAll().stream()
                .map(ReservationMapper::toResponseDTO)
                .collect(Collectors.toSet());
        } catch (Exception e) {
            System.err.println("Error en listAllReservations: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public ReservationResponseDTO listReservationById(Long id) {
        try {
            Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation con ID " + id + " no encontrada"));

            return ReservationMapper.toResponseDTO(reservation);
        } catch (Exception e) {
            System.err.println("Error en listReservationById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public ReservationResponseDTO updateById(Long id, ReservationRequestDTO reservationRequestDTO) {
        try {
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
                    .orElseThrow(() -> new IllegalArgumentException("Client no encontrado")); }

            ReservationMapper.updateEntityFromDTO(existing, flight, client, reservationRequestDTO);

            Reservation updated = reservationRepository.save(existing);

            return ReservationMapper.toResponseDTO(updated);
        } catch (Exception e) {
            System.err.println("Error en updateById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (!reservationRepository.existsById(id)) {
                throw new IllegalArgumentException("Reservation con ID " + id + " no encontrada para eliminación");
            }
            reservationRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error en deleteById para id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Set<ReservationResponseDTO> findByAirportId(Long airportId) {
        try {
            if (airportId == null) throw new IllegalArgumentException("airportId no puede ser nulo");
            return reservationRepository.findByAirportId(airportId).stream()
                .map(ReservationMapper::toResponseDTO)
                .collect(Collectors.toSet());
        } catch (Exception e) {
            System.err.println("Error en findByAirportId para airportId " + airportId + ": " + e.getMessage());
            throw e;
        }
    }

}
