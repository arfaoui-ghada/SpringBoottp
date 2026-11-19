package com.example.demo.Services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Client;
import com.example.demo.Repository.IClientRepository;
import com.example.demo.Services.IClientServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServices implements IClientServices {

    private final IClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    @Override
    public Client updateClient(Long id, Client client) {
        clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
        client.setIdClient(id);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
