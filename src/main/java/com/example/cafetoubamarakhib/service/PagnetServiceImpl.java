package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Commande;
import com.example.cafetoubamarakhib.model.Pagnet;
import com.example.cafetoubamarakhib.repository.CommandeRepository;
import com.example.cafetoubamarakhib.repository.PagnetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagnetServiceImpl implements PagnetService{
    private final PagnetRepository pagnetRepository;
    private final CommandeRepository commandeRepository;

    public PagnetServiceImpl(PagnetRepository pagnetRepository, CommandeRepository commandeRepository) {
        this.pagnetRepository = pagnetRepository;
        this.commandeRepository = commandeRepository;
    }

    @Override
    public List<Pagnet> getAllPagnet() {
        return null;
    }

    @Override
    public Pagnet addPagnet(Pagnet pagnet) {
        return pagnetRepository.save(pagnet);
    }

    @Override
    public Pagnet updatePagnet(long id, Pagnet pagnet) {
        return null;
    }

    @Override
    public void deletePagnet(long id) {
        Commande commande=commandeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("la commande que vous tenter de suprimer n existe pas"));
        commandeRepository.save(commande);
    }

    @Override
    public Pagnet getPagnetById(long id) {
        return null;
    }
}
