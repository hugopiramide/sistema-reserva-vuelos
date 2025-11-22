package com.airport.ProjectBookingFlights.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airport.ProjectBookingFlights.model.Airport;

@Repository
public interface IAirportRepository extends JpaRepository<Airport, Long>{
    
    // Total vuelos del aeropuerto
    @Query("SELECT COUNT(f) FROM Flight f WHERE f.origin.id = :airportId OR f.destination.id = :airportId")
    Long countFlightsByAirportId(Long airportId);
}
