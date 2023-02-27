package com.example.cafetoubamarakhib.controller;

import com.example.cafetoubamarakhib.Dto.ClientDto;
import com.example.cafetoubamarakhib.Dto.GestionaireDto;
import com.example.cafetoubamarakhib.Dto.PersoneDto;
import com.example.cafetoubamarakhib.model.Client;
import com.example.cafetoubamarakhib.model.Gestionaire;
import com.example.cafetoubamarakhib.model.Personne;
import com.example.cafetoubamarakhib.service.ClientService;
import com.example.cafetoubamarakhib.service.GestionaireService;
import com.example.cafetoubamarakhib.service.PersonneService;
import com.example.cafetoubamarakhib.service.mapper.ClientMapStruct;
import com.example.cafetoubamarakhib.service.mapper.GestionaireMapStruct;
import com.example.cafetoubamarakhib.service.mapper.PersonneMapStruct;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@CrossOrigin(origins = "", allowedHeaders = "*")
@RequestMapping("/api")
public class PersonneController {
    private final PersonneService personneService;
    private final ClientService clientService;
    private final GestionaireService gestionaireService;
    private final PersonneMapStruct personneMapStruct;
    private final ClientMapStruct clientMapStruct;
    private final GestionaireMapStruct gestionaireMapStruct;
    private final ModelMapper modelMapper;

    public PersonneController(PersonneService personneService, ClientService clientService, GestionaireService gestionaireService, PersonneMapStruct personneMapStruct, ClientMapStruct clientMapStruct, GestionaireMapStruct gestionaireMapStruct, ModelMapper modelMapper) {
        this.personneService = personneService;
        this.clientService = clientService;
        this.gestionaireService = gestionaireService;
        this.personneMapStruct = personneMapStruct;
        this.clientMapStruct = clientMapStruct;
        this.gestionaireMapStruct = gestionaireMapStruct;
        this.modelMapper = modelMapper;
    }

    //*********************************RECUPERER TOUT LES UTILISATEUR**********************************
    @GetMapping("/{type}")
    public List<PersoneDto> getAllPersonne(@PathVariable String type) {
        if (type.equalsIgnoreCase("personne")) {
            return personneService.getAllPersonne().stream().map(personne -> modelMapper.map(personne, PersoneDto.class)).collect(Collectors.toList());
        } else if (type.equalsIgnoreCase("client")) {
            return clientService.getAllClient().stream().map(client -> modelMapper.map(client, ClientDto.class)).collect(Collectors.toList());

        } else if (type.equalsIgnoreCase("gestionaire")) {
            return gestionaireService.getAllGestionaire().stream().map(gestionaire -> modelMapper.map(gestionaire, GestionaireDto.class)).collect(Collectors.toList());
        }
        return null;
    }

    //**************RECUPERER UN UTILISATEUR APARTIR DE SON IDENTIFIANT******************************
    @GetMapping("/{type}/{id}")
    public ResponseEntity<PersoneDto> getPersonneById(@PathVariable(name = "id") Long id, @PathVariable String type) {
        if (type.equalsIgnoreCase("client")) {
            Client client = clientService.getClientById(id);
            ClientDto postResponse = clientMapStruct.toDto(client);
            return ResponseEntity.ok().body(postResponse);

        } else if (type.equalsIgnoreCase("gestionaire")) {

            Gestionaire gestionaire = gestionaireService.getGestionaireById(id);
            GestionaireDto postResponse = gestionaireMapStruct.toDto(gestionaire);
            return ResponseEntity.ok().body(postResponse);

        }
        return null;
    }
    //*************************UPDATE UTILISATEUR******************************

    @PutMapping("/{type}/{id}")
    public ResponseEntity<PersoneDto> updatePersone(@PathVariable Long id, @PathVariable String type, @RequestBody PersoneDto personeDto) {
        if (type.equalsIgnoreCase("personne")) {
            Personne personneRequest = personneMapStruct.toEntity(personeDto);
            Personne personne = personneService.updatePersonne(id, personneRequest);
            PersoneDto personneResponse = personneMapStruct.toDto(personne);
            return ResponseEntity.ok().body(personneResponse);
        }
        return null;
    }

    @PostMapping("/client")
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto) {
        Client clientRequest = clientMapStruct.toEntity(clientDto);
        Client client = clientService.addClient(clientRequest);
        ClientDto clientResponse = clientMapStruct.toDto(client);
        return ResponseEntity.ok().body(clientResponse);
    }

    @PostMapping("/gestionaire")
    public ResponseEntity<GestionaireDto> saveGestionaire(@RequestBody GestionaireDto gestionaireDto) {
        log.info("bonjour gestionaire");
        Gestionaire gestionaireRequest = gestionaireMapStruct.toEntity(gestionaireDto);
        Gestionaire gestionaire = gestionaireService.addGestionaire(gestionaireRequest);
        GestionaireDto gestionaireResponse = gestionaireMapStruct.toDto(gestionaire);
        return ResponseEntity.ok().body(gestionaireResponse);
    }

    @DeleteMapping("/{type}/{id}")
    public ResponseEntity<?>deletePersonne(@PathVariable(name = "id") Long id,@PathVariable String type)
    {
        if (type.equalsIgnoreCase("personne")) {
            personneService.deletePersonne(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return null;
    }

}