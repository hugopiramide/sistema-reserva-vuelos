package com.airport.ProjectBookingFlights.model.vo;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class ClientEmail {
    
    private final String email;
    
    public ClientEmail(){
        this.email = null;
    }
    
    public ClientEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientEmail other = (ClientEmail) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }
    
}
