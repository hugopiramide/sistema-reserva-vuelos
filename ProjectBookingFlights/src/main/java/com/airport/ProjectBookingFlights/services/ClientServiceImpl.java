package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IClientService;
import com.airport.ProjectBookingFlights.model.dto.request.ClientRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ClientResponseDTO;
import com.airport.ProjectBookingFlights.repositories.IClientRepository;

import java.util.Set;
import java.util.HashSet;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {
    
    private IClientRepository clientRepository;
    
    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @Override
    public ClientResponseDTO insertClient(ClientRequestDTO clientRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public Set<ClientResponseDTO> listAllClients() {
        // TODO: Implement logic
        return new HashSet<>();
    }

    @Override
    public ClientResponseDTO listClientById(Long id) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public ClientResponseDTO updateById(Long id, ClientRequestDTO clientRequestDTO) {
        // TODO: Implement logic
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO: Implement logic
    }
}
