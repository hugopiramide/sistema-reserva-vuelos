package com.airport.ProjectBookingFlights.mappers;

import com.airport.ProjectBookingFlights.model.Client;
import com.airport.ProjectBookingFlights.model.Flight;
import com.airport.ProjectBookingFlights.model.Reservation;
import com.airport.ProjectBookingFlights.model.dto.request.ReservationRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ClientResponseDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightResponseDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ReservationResponseDTO;
import com.airport.ProjectBookingFlights.model.vo.ClientEmail;

public class ReservationMapper {

    public static Reservation toEntity(Flight flight, Client client, ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = new Reservation(flight, client);
        return reservation;
    }

    public static ReservationResponseDTO toResponseDTO(Reservation reservation) {
        ReservationResponseDTO response = new ReservationResponseDTO();
        response.setBookingDate(reservation.getBookingDate());
        response.setStatus(reservation.getStatus().name());
        response.setClient(new ClientResponseDTO(
                reservation.getClient().getName(),
                reservation.getClient().getFirstName(),
                reservation.getClient().getEmail().getEmail()));
        response.setFlight(new FlightResponseDTO(
                reservation.getFlight().getOriginAirport().getName(),
                reservation.getFlight().getDestinationAirport().getName(),
                reservation.getFlight().getDepartureTime(),
                reservation.getFlight().getArrivalTime(),
                reservation.getFlight().getPassengers().getTotal(),
                reservation.getFlight().getAvailableSeats()));
        return response;
    }

    public static void updateEntityFromDTO(Reservation existing, Flight flight, Client client,
            ReservationRequestDTO dto) {
        if (existing == null || dto == null)
            return;

        if (flight != null) {
            existing.setFlight(flight);
        }
        if (client != null) {
            existing.setClient(client);
        }
    }

}
