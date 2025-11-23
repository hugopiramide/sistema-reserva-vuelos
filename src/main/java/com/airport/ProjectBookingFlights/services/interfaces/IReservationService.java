package com.airport.ProjectBookingFlights.services.interfaces;

import java.util.Set;

import com.airport.ProjectBookingFlights.model.dto.request.ReservationRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ReservationResponseDTO;

public interface IReservationService {

	public ReservationResponseDTO insertReservation(ReservationRequestDTO reservationRequestDTO);

	public Set<ReservationResponseDTO> listAllReservations();

	public ReservationResponseDTO listReservationById(Long id);

	public Set<ReservationResponseDTO> findByAirportId(Long airportId);

	public ReservationResponseDTO updateById(Long id, ReservationRequestDTO reservationRequestDTO);

	public void deleteById(Long id);
}
