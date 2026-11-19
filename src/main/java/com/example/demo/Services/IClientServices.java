package com.example.demo.Services;

import com.example.demo.Agence;
import com.example.demo.Client;

import java.util.List;

public interface IClientServices {
    Client addClient (Client client);
    Client getClient(Long id);
    Client updateClient (Long id, Client client);
    void deleteClient(Long id);
    List<Client> getAll();
}
