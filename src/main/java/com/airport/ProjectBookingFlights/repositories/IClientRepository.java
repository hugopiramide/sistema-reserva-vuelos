package com.airport.ProjectBookingFlights.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airport.ProjectBookingFlights.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{
    
    // Clientes que han realizado más de N reservas
    @Query("SELECT c FROM Client c WHERE SIZE(c.reservations) >= :minReservations")
    Set<Client> findClientsWithMoreThanNReservations(Long minReservations);

}
