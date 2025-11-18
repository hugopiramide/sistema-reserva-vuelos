package com.airport.ProjectBookingFlights.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.ProjectBookingFlights.model.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long> {

}
