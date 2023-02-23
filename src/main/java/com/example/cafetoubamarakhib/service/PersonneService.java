package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Cafe;
import com.example.cafetoubamarakhib.model.Personne;

import java.util.List;

public interface PersonneService {
    List<Personne> getAllPersonne();
    Personne addPersonne(Personne personne);
    Personne updatePersonne(long id,Personne personne);
    void deletePersonne(long id);
    Personne getPersonneById(long id);

}
