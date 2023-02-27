package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Personne;
import com.example.cafetoubamarakhib.repository.PersonneRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneServiceImpl implements PersonneService {
    private final PersonneRepository personneRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public List<Personne> getAllPersonne() {
        return personneRepository.findAll();
    }

    @Override
    public Personne addPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public Personne updatePersonne(long id, Personne personneRequest) {
        Personne personne = personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("la recuperation de la personne n'a pas abouti"));
        personne.setNom(personneRequest.getNom());
        personne.setUsername(personneRequest.getUsername());
        personne.setType(personneRequest.getType());
        return personneRepository.save(personne);
    }

    @Override
    public void deletePersonne(long id) {
        Personne personne = personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("la personne que vous tenter de supprimer existent pas"));
        personneRepository.delete(personne);

    }

    @Override
    public Personne getPersonneById(long id) {
        Optional<Personne> result = personneRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("la personne que vous chercher n existe pas");
        }
    }
}
