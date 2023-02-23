package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.CafeDto;
import com.example.cafetoubamarakhib.model.Cafe;
import org.modelmapper.ModelMapper;

public class CafeMapStructImpl implements CafeMapStruct{
    private final ModelMapper modelMapper;

    public CafeMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CafeDto toDto(Cafe cafe) {
        return modelMapper.map(cafe,CafeDto.class);
    }

    @Override
    public Cafe toEntity(CafeDto cafeDto) {
        return modelMapper.map(cafeDto,Cafe.class);
    }
}
