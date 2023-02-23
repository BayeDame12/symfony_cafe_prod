package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.GestionaireDto;
import com.example.cafetoubamarakhib.Dto.PersoneDto;
import com.example.cafetoubamarakhib.model.Gestionaire;
import com.example.cafetoubamarakhib.model.Personne;

public interface PersonneMapStruct {
    PersoneDto toDto (Personne personne);
    Personne toEntity(PersoneDto personneDto);

}
