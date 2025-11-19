package com.airport.ProjectBookingFlights.model.vo;

import java.util.Objects;
import java.util.regex.Pattern;

import jakarta.persistence.Embeddable;

@Embeddable
public final class ClientEmail {

    private static final String REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private final String email;

    public ClientEmail() {
        this.email = null;
    }

    public ClientEmail(String email) {
        if (!patternMatches(email, REGEX_PATTERN))
            throw new MatchException("El email :" + email + ", no es válido", null);
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

    public static boolean patternMatches(String email, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }

}
