package com.airport.ProjectBookingFlights.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airport.ProjectBookingFlights.model.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long> {
    
    // Vuelos en los que ha participado un cliente específico
    @Query("SELECT f FROM Flight f INNER JOIN FETCH f.reservations r WHERE r.client.id = :clientId")
    Set<Flight> findFlightsByClientId(Long clientId);

}
