package com.airport.ProjectBookingFlights.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airport.ProjectBookingFlights.model.FlightService;

@Repository
public interface IFlightServiceRepository extends JpaRepository<FlightService, Long> {
    
    // Servicios asociados a un vuelo específico
    @Query("SELECT fs FROM FlightService fs INNER JOIN FETCH fs.flights f WHERE f.id = :flightId")
    Set<FlightService> findServicesByFlightId(Long flightId);

}
