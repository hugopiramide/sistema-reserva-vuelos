package com.airport.ProjectBookingFlights.services.interfaces;

import java.util.Set;

import com.airport.ProjectBookingFlights.model.dto.request.ClientRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ClientResponseDTO;

public interface IClientService {

	public ClientResponseDTO insertClient(ClientRequestDTO clientRequestDTO);

	public Set<ClientResponseDTO> listAllClients();

	public ClientResponseDTO listClientById(Long id);

	public ClientResponseDTO updateById(Long id, ClientRequestDTO clientRequestDTO);

	public void deleteById(Long id);
}
