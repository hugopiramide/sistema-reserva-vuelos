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
        try {
            return clientService.listAllClients();
        } catch (Exception e) {
            System.err.println("Error al obtener todos los clientes: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ClientResponseDTO getClientById(@PathVariable Long id) {
        try {
            return clientService.listClientById(id);
        } catch (Exception e) {
            System.err.println("Error al obtener cliente por id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/by-min-reservations/{min}")
    public Set<ClientResponseDTO> getClientsWithMoreThanNReservations(@PathVariable Long min) {
        try {
            return clientService.findClientsWithMoreThanNReservations(min);
        } catch (Exception e) {
            System.err.println("Error al buscar clientes con más de " + min + " reservaciones: " + e.getMessage());
            throw e;
        }
    }

    @PostMapping
    public ClientResponseDTO postClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        try {
            return clientService.insertClient(clientRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al crear cliente: " + e.getMessage());
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ClientResponseDTO putClientById(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        try {
            return clientService.updateById(id, clientRequestDTO);
        } catch (Exception e) {
            System.err.println("Error al actualizar cliente con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            clientService.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar cliente con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

}
