package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.ClientDto;
import com.example.cafetoubamarakhib.Dto.CommandeDto;
import com.example.cafetoubamarakhib.model.Client;
import com.example.cafetoubamarakhib.model.Commande;

public interface CommandeMapStruct {

    CommandeDto toDto (Commande commande);
    Commande toEntity(CommandeDto commandeDto);
}
