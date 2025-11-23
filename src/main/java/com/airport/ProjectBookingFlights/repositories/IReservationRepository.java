package com.airport.ProjectBookingFlights.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airport.ProjectBookingFlights.model.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    // Buscar las reservas asociadas a un aeropuerto específico (sin importar si es
    // origen o destino)
    @Query("SELECT r FROM Reservation r WHERE r.flight.originAirport.airport_id = :airportId OR r.flight.destinationAirport.airport_id = :airportId")
    Set<Reservation> findByAirportId(Long airportId);

}
