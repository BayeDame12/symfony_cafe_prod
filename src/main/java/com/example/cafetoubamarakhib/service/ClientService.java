package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Client;
import com.example.cafetoubamarakhib.model.Commande;

import java.util.List;

public interface ClientService {
    List<Client> getAllClient();

    Client addClient(Client client);

    Client updateClient(long id, Client client);

    void deleteClient(long id);

    Client getClientById(long id);
}
