package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Gestionaire;
import com.example.cafetoubamarakhib.repository.GestionaireRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GestionaireServiceImpl implements GestionaireService {
    private final GestionaireRepository gestionaireRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public GestionaireServiceImpl(GestionaireRepository gestionaireRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.gestionaireRepository = gestionaireRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<Gestionaire> getAllGestionaire() {
        return gestionaireRepository.findAll();
    }

    @Override
    public Gestionaire addGestionaire(Gestionaire gestionaire) {
        return gestionaireRepository.save(gestionaire);
    }

    @Override
    public Gestionaire updateGestionaire(long id, Gestionaire gestionaireRequest) {
        Gestionaire gestionaire = gestionaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("la Gestionaire que vous tenter de supprimer existent pas"));
        gestionaire.setPrenom(gestionaireRequest.getPrenom());
        gestionaire.setNom(gestionaireRequest.getNom());
        gestionaire.setLogin(gestionaireRequest.getLogin());
        gestionaire.setPassword(bCryptPasswordEncoder.encode(gestionaireRequest.getPassword()));
        return gestionaireRepository.save(gestionaire);
    }

    @Override
    public void deleteGestionaire(long id) {
        Gestionaire gestionaire = gestionaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("la gestionaire que vous tenter de supprimer existent pas"));
        gestionaireRepository.delete(gestionaire);

    }

    @Override
    public Gestionaire getGestionaireById(long id) {
        Optional<Gestionaire> result = gestionaireRepository.findById(id);
        if (result.isPresent()) {
            return result.get();

        } else {
            throw new RuntimeException("la Gestionaire que vous chercher n existe pas");
        }
    }
}
