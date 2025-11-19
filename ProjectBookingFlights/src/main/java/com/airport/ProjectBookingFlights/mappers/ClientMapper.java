package com.airport.ProjectBookingFlights.mappers;

import com.airport.ProjectBookingFlights.model.Client;
import com.airport.ProjectBookingFlights.model.dto.request.ClientRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ClientResponseDTO;
import com.airport.ProjectBookingFlights.model.vo.ClientEmail;

public class ClientMapper {
    
    public static Client toEntity(ClientRequestDTO clientRequestDTO){
        Client client = new Client();
        client.setName(clientRequestDTO.getName());
        client.setEmail(new ClientEmail(clientRequestDTO.getEmail()));
        client.setFirstName(clientRequestDTO.getFirstName());
        return client;
    } 
    
    public static ClientResponseDTO toResponse(Client client){
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setName(client.getName());
        dto.setFirstName(client.getFirstName());
        dto.setEmail(client.getEmail().getEmail());
        return dto;
    }

}
