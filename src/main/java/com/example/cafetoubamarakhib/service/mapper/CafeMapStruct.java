package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.CafeDto;
import com.example.cafetoubamarakhib.Dto.ClientDto;
import com.example.cafetoubamarakhib.model.Cafe;
import com.example.cafetoubamarakhib.model.Client;

public interface CafeMapStruct {
    CafeDto toDto (Cafe cafe);
    Cafe toEntity(CafeDto cafeDto);
}
