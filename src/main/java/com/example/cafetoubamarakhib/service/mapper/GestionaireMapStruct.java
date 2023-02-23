package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.GestionaireDto;
import com.example.cafetoubamarakhib.model.Gestionaire;

public interface GestionaireMapStruct {
    GestionaireDto toDto (Gestionaire gestionaire);
    Gestionaire toEntity(GestionaireDto gestionaireDto);
}
