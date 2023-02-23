package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.CommandeDto;
import com.example.cafetoubamarakhib.model.Commande;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommandeMapStructImpl implements CommandeMapStruct{
    private final ModelMapper modelMapper;

    public CommandeMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CommandeDto toDto(Commande commande) {
        return modelMapper.map(commande,CommandeDto.class);
    }

    @Override
    public Commande toEntity(CommandeDto commandeDto) {
        return modelMapper.map(commandeDto,Commande.class);
    }
}
