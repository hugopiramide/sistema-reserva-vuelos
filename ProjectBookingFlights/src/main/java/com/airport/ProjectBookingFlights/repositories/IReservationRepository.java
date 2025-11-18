package com.airport.ProjectBookingFlights.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.ProjectBookingFlights.model.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long>{
    
}
