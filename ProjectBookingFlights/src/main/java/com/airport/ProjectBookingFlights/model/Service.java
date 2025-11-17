package com.airport.ProjectBookingFlights.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long service_id;
    
    @Column(name = "name", length = 100)
    private String name;
    
    @Column(name = "description", length = 255)
    private String description;
    
    @ManyToMany(mappedBy = "services")
    private Set<Flight> flights;

    public Service() {
        
    }

    public Service(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service [service_id=" + service_id + ", name=" + name + ", description=" + description + "]";
    }
    
}
