package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Commande;
import com.example.cafetoubamarakhib.repository.CommandeRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(long id, Commande commandeRequest) {
        Commande commande=commandeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("la recuperation de la commande n'a pas abouti"));
        commande.setNumeroCommande(commandeRequest.getNumeroCommande());
        commande.setDate(commandeRequest.getDate());
        commande.setPrix(commandeRequest.getPrix());
        commande.setContenu(commandeRequest.getContenu());
        commande.setCafes(commandeRequest.getCafes());
        commande.setClient(commandeRequest.getClient());
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(long id) {
     Commande commande=commandeRepository.findById(id)
             .orElseThrow(()->new RuntimeException(""));
     commandeRepository.delete(commande);
    }

    @Override
    public Commande getCommandeById(long id) {
        Optional<Commande>result=commandeRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        else {
            throw new ResourceNotFoundException("la commande que vous chercher n existe pas");
        }
    }
}
