package com.airport.ProjectBookingFlights.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.ProjectBookingFlights.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{
    
}
