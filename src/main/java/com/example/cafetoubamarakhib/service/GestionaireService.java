package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Client;
import com.example.cafetoubamarakhib.model.Gestionaire;

import java.util.List;

public interface GestionaireService {
    List< Gestionaire> getAllGestionaire();

    Gestionaire addGestionaire( Gestionaire gestionaire);

    Gestionaire updateGestionaire(long id,  Gestionaire gestionaire);

    void deleteGestionaire(long id);

    Gestionaire getGestionaireById(long id);
}
