package com.example.cafetoubamarakhib.Dto;

import com.example.cafetoubamarakhib.model.Gestionaire;
import lombok.Data;

public class ClientDto extends PersoneDto{
    private String msisdn;
    private String adresse;
    private Gestionaire gestionaire;

}
