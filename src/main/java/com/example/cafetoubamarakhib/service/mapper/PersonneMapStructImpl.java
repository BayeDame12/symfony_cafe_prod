package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.PersoneDto;
import com.example.cafetoubamarakhib.model.Personne;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonneMapStructImpl implements PersonneMapStruct{
    private final ModelMapper modelMapper;

    public PersonneMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PersoneDto toDto(Personne personne) {
        return modelMapper.map(personne,PersoneDto.class);
    }

    @Override
    public Personne toEntity(PersoneDto personneDto) {
        return modelMapper.map(personneDto,Personne.class);
    }
}
