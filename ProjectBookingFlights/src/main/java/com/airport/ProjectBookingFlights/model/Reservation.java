package com.airport.ProjectBookingFlights.model;

import java.time.LocalDateTime;

import com.airport.ProjectBookingFlights.model.enums.Status;
import com.airport.ProjectBookingFlights.model.vo.Passengers;
import com.airport.ProjectBookingFlights.model.vo.UserEmail;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
 
    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "user_email", length = 120, nullable = false))
    private UserEmail userEmail;

    @Embedded
    @AttributeOverride(name = "total", column = @Column(name = "passengers", length = 4))
    private Passengers passengers;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Reservation() {
    }

    public Reservation(UserEmail userEmail, Passengers passengers, LocalDateTime bookingDate, Status status,
            Flight flight) {
        this.userEmail = userEmail;
        this.passengers = passengers;
        this.bookingDate = bookingDate;
        this.status = status;
        this.flight = flight;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public UserEmail getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(UserEmail userEmail) {
        this.userEmail = userEmail;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
        this.passengers = passengers;
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

    @Override
    public String toString() {
        return "Reservation [reservation_id=" + reservation_id + ", userEmail=" + userEmail + ", passengers="
                + passengers + ", bookingDate=" + bookingDate + ", status=" + status + ", flight=" + flight + "]";
    }
    
}
