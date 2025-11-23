package com.airport.ProjectBookingFlights.services;

import com.airport.ProjectBookingFlights.services.interfaces.IClientService;
import com.airport.ProjectBookingFlights.model.dto.request.ClientRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ClientResponseDTO;
import com.airport.ProjectBookingFlights.mappers.ClientMapper;
import com.airport.ProjectBookingFlights.model.Client;
import java.util.stream.Collectors;
import com.airport.ProjectBookingFlights.repositories.IClientRepository;

import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {
    
    private IClientRepository clientRepository;
    
    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @Override
    public ClientResponseDTO insertClient(ClientRequestDTO clientRequestDTO) {
        if (clientRequestDTO == null) {
            throw new IllegalArgumentException("ClientRequestDTO no puede ser nulo");
        }

        Client client = ClientMapper.toEntity(clientRequestDTO);
        clientRepository.save(client);

        return ClientMapper.toResponse(client);
    }

    @Override
    public Set<ClientResponseDTO> listAllClients() {
        return clientRepository.findAll().stream()
            .map(ClientMapper::toResponse)
            .collect(Collectors.toSet());
    }

    @Override
    public ClientResponseDTO listClientById(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Cliente con ID " + id + " no encontrado"));
        return ClientMapper.toResponse(client);
    }

    @Override
    public ClientResponseDTO updateById(Long id, ClientRequestDTO clientRequestDTO) {
        if (clientRequestDTO == null) {
            throw new IllegalArgumentException("ClientRequestDTO no puede ser nulo");
        }

        Client existing = clientRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Cliente con id " + id + " no existe"));

        ClientMapper.updateEntityFromDTO(existing, clientRequestDTO);

        Client updated = clientRepository.save(existing);

        return ClientMapper.toResponse(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente con ID " + id + " no encontrado para eliminación");
        }
        clientRepository.deleteById(id);
    }

    @Override
    public Set<ClientResponseDTO> findClientsWithMoreThanNReservations(Long minReservations) {
        if (minReservations < 0) throw new IllegalArgumentException("minReservations no puede ser negativo");
        return clientRepository.findClientsWithMoreThanNReservations(minReservations).stream()
            .map(com.airport.ProjectBookingFlights.mappers.ClientMapper::toResponse)
            .collect(java.util.stream.Collectors.toSet());
    }

}
