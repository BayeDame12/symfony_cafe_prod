package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.ClientDto;
import com.example.cafetoubamarakhib.model.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientMapStructImpl implements ClientMapStruct{
    private final ModelMapper modelMapper;

    public ClientMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientDto toDto(Client client) {
        return modelMapper.map(client,ClientDto.class);
    }

    @Override
    public Client toEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto,Client.class);
    }
}
