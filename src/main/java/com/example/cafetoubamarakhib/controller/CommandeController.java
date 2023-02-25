package com.example.cafetoubamarakhib.controller;

import com.example.cafetoubamarakhib.Dto.ClientDto;
import com.example.cafetoubamarakhib.Dto.CommandeDto;
import com.example.cafetoubamarakhib.Dto.GestionaireDto;
import com.example.cafetoubamarakhib.Dto.PersoneDto;
import com.example.cafetoubamarakhib.model.Client;
import com.example.cafetoubamarakhib.model.Commande;
import com.example.cafetoubamarakhib.model.Gestionaire;
import com.example.cafetoubamarakhib.model.Personne;
import com.example.cafetoubamarakhib.service.CommandeService;
import com.example.cafetoubamarakhib.service.mapper.CommandeMapStruct;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/api/commande")
@CrossOrigin(origins = "", allowedHeaders = "*")


public class CommandeController {
    private final CommandeService commandeService;
    private final ModelMapper modelMapper;
    private final CommandeMapStruct commandeMapStruct;

    public CommandeController(CommandeService commandeService, ModelMapper modelMapper, CommandeMapStruct commandeMapStruct) {
        this.commandeService = commandeService;
        this.modelMapper = modelMapper;
        this.commandeMapStruct = commandeMapStruct;
    }


    @GetMapping
    public List<CommandeDto> getAllCommande() {
            return commandeService.getAllCommande().stream().map(commande -> modelMapper.map(commande, CommandeDto.class)).collect(Collectors.toList());
        }

    //**************RECUPERER UN UTILISATEUR APARTIR DE SON IDENTIFIANT******************************
    @GetMapping("/{id}")
    public ResponseEntity<CommandeDto> getCommandeById(@PathVariable(name = "id") Long id) {
            Commande commande = commandeService.getCommandeById(id);
            CommandeDto postResponse = commandeMapStruct.toDto(commande);
            return ResponseEntity.ok().body(postResponse);

        }
    //*************************UPDATE UTILISATEUR******************************

    @PutMapping("/{id}")
    public ResponseEntity<CommandeDto> updateCommande(@PathVariable Long id, @RequestBody CommandeDto commandeDto) {
            Commande commandeRequest = commandeMapStruct.toEntity(commandeDto);
            Commande commande = commandeService.updateCommande(id, commandeRequest);
            CommandeDto commandeResponse = commandeMapStruct.toDto(commande);
            return ResponseEntity.ok().body(commandeResponse);
        }
    @PostMapping("/commande")
    public ResponseEntity<CommandeDto> saveCommande(@RequestBody CommandeDto commandeDto) {
        Commande commandeRequest = commandeMapStruct.toEntity(commandeDto);
        Commande commande = commandeService.addCommande(commandeRequest);
        CommandeDto commandeResponse = commandeMapStruct.toDto(commande);
        return ResponseEntity.ok().body(commandeDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable(name = "id") Long id) {
            commandeService.deleteCommande(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

}
