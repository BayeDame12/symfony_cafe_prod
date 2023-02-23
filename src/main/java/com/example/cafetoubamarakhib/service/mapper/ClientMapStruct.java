package com.example.cafetoubamarakhib.service.mapper;

import com.example.cafetoubamarakhib.Dto.ClientDto;
import com.example.cafetoubamarakhib.model.Client;

public interface ClientMapStruct {
    ClientDto toDto (Client client);
    Client toEntity(ClientDto clientDto);
}
