package com.airport.ProjectBookingFlights.mappers;

import com.airport.ProjectBookingFlights.model.Airport;
import com.airport.ProjectBookingFlights.model.Flight;
import com.airport.ProjectBookingFlights.model.dto.request.FlightRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.FlightResponseDTO;
import com.airport.ProjectBookingFlights.model.vo.Passengers;

public class FlightMapper {
    
    /*
     * Hay que pasar el Aeropuerto origen y destino en el constructor,
     * debido a que no queremos romper el principio de los Mapper (Ya que es posible inyectar el repo aquí, hacer la consulta dentro de toEntity() y obtener el objeto Airport).
     * Por lo tanto, lo voy a ecargar al servicio y que busque por ID en la BD.
    */

    public static Flight toEntity(Airport origin, Airport destination, FlightRequestDTO flightRequestDTO){
        Flight flight = new Flight();
        flight.setArrivalTime(flightRequestDTO.getArrivalTime());
        flight.setDepartureTime(flightRequestDTO.getDepartureTime());
        flight.setOriginAirport(origin);
        flight.setDestinationAirport(destination);
        flight.setPassengers(new Passengers());
        flight.setAvailableSeats(flightRequestDTO.getCapacity());
        return flight;
    }
    
    public static FlightResponseDTO toResponseDTO(Flight flight){
        FlightResponseDTO dto = new FlightResponseDTO();
        dto.setArrivalTime(flight.getArrivalTime());
        dto.setDepartureTime(flight.getDepartureTime());
        dto.setDestinationAirport(flight.getDestinationAirport().getName());
        dto.setOriginAirport(flight.getOriginAirport().getName());
        dto.setAvailableSeats(flight.getAvailableSeats());
        dto.setCapacity(flight.getPassengers().getTotal());
        return dto;
    }

    public static void updateEntityFromDTO(Flight flight, Airport origin, Airport destination, FlightRequestDTO dto) {
        if (flight == null || dto == null) return;

        if (origin != null) {
            flight.setOriginAirport(origin);
        }
        if (destination != null) {
            flight.setDestinationAirport(destination);
        }
        if (dto.getDepartureTime() != null) {
            flight.setDepartureTime(dto.getDepartureTime());
        }
        if (dto.getArrivalTime() != null) {
            flight.setArrivalTime(dto.getArrivalTime());
        }
        if (dto.getCapacity() != null) {
            flight.setAvailableSeats(dto.getCapacity());
            flight.setPassengers(new Passengers(dto.getCapacity()));
        }
    }
}
