package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Client;
import com.example.cafetoubamarakhib.repository.ClientRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(long id, Client clientRequest) {
        Client client=clientRepository.findById(id)
                .orElseThrow(()->new RuntimeException("la recuperation du client n'a pas abouti"));
        client.setPrenom(clientRequest.getPrenom());
        client.setNom(clientRequest.getNom());
        client.setMsisdn(clientRequest.getMsisdn());
        client.setAdresse(clientRequest.getAdresse());
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("le client que vous tenter de supprimer n'existe pas"));
        clientRepository.delete(client);
    }

    @Override
    public Client getClientById(long id) {
        Optional<Client> result = clientRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("la client que vous chercher n existe pas");
        }
    }
}
