package com.airport.ProjectBookingFlights.model;

import java.util.Set;

import com.airport.ProjectBookingFlights.model.vo.ClientEmail;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long client_id;
    
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "first_name", length = 120, nullable = true)
    private String firstName;
    
    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "email", length = 120, nullable = false))
    private ClientEmail email;
    
    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;
    
    public Client(){
    }

    public Client(Long client_id, String name, String firstName, ClientEmail email, Set<Reservation> reservations) {
        this.client_id = client_id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.reservations = reservations;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ClientEmail getEmail() {
        return email;
    }

    public void setEmail(ClientEmail email) {
        this.email = email;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Client [client_id=" + client_id + ", name=" + name + ", first_name=" + firstName + ", email=" + email
                + ", reservations=" + reservations + "]";
    }

}
