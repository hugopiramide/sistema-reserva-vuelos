package com.airport.ProjectBookingFlights.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.ProjectBookingFlights.model.dto.request.ClientRequestDTO;
import com.airport.ProjectBookingFlights.model.dto.response.ClientResponseDTO;
import com.airport.ProjectBookingFlights.services.interfaces.IClientService;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public Set<ClientResponseDTO> getAllClients() {
        return clientService.listAllClients();
    }

    @GetMapping("/{id}")
    public ClientResponseDTO getClientById(@PathVariable Long id) {
        return clientService.listClientById(id);
    }

    @PostMapping("/save")
    public ClientResponseDTO postClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        return clientService.insertClient(clientRequestDTO);
    }

    @PutMapping("/save/{id}")
    public ClientResponseDTO putClientById(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        return clientService.updateById(id, clientRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

}
