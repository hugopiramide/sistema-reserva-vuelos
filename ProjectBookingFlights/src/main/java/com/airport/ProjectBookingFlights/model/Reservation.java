package com.airport.ProjectBookingFlights.model;

import java.time.LocalDateTime;

import com.airport.ProjectBookingFlights.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Reservation() {
    }

    public Reservation(Long reservation_id, LocalDateTime bookingDate, Status status,
            Flight flight, Client client) {
        this.reservation_id = reservation_id;
        this.bookingDate = bookingDate;
        this.status = status;
        this.flight = flight;
        this.client = client;
    }

    /* Pongo el Status.CONFIRMED por defecto al crear una Reserva (Este a lo largo del programa, podrá modificarse, etc.) */

    public Reservation(LocalDateTime bookingDate, Flight flight, Client client) {
        this.bookingDate = bookingDate;
        this.flight = flight;
        this.client = client;
        this.status = Status.CONFIRMED;
    }

    /* El bookingDate se puede definir al crear la propia Reserva ( .now() ) */

    public Reservation(Flight flight, Client client) {
        this.bookingDate = LocalDateTime.now();
        this.flight = flight;
        this.client = client;
        this.status = Status.CONFIRMED;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation [reservation_id=" + reservation_id + ", bookingDate=" + bookingDate + ", status=" + status
                + ", flight=" + flight + ", client=" + client + "]";
    }

}
