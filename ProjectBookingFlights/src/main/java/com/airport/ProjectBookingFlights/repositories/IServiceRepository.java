package com.airport.ProjectBookingFlights.repositories;

import java.security.Provider.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Long>{
    
}
