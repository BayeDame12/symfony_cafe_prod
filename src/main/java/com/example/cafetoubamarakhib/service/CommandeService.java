package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Cafe;
import com.example.cafetoubamarakhib.model.Commande;

import java.util.List;

public interface CommandeService {
    List<Commande> getAllCommande();

    Commande addCommande(Commande commande);

    Commande updateCommande(long id, Commande commande);

    void deleteCommande(long id);

    Commande getCommandeById(long id);

}
