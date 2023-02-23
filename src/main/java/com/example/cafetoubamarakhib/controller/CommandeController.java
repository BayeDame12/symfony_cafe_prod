package com.example.cafetoubamarakhib.controller;

import com.example.cafetoubamarakhib.Dto.PersoneDto;
import com.example.cafetoubamarakhib.service.CommandeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CommandeController {
    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }
}
