package com.airport.ProjectBookingFlights.model.vo;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Passengers{
    
    private final Integer total;

    public Passengers(){
        this.total = null;
    }

    public Passengers(Integer total){
        if(total < 0) throw new ArrayIndexOutOfBoundsException("El valor no puede ser negativo"); // Mejorable este Exception
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Passengers other = (Passengers) obj;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Passengers [total=" + total + "]";
    }

}
