package com.example.cafetoubamarakhib.Dto;

import com.example.cafetoubamarakhib.model.Gestionaire;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientDto extends PersoneDto {
    private Long id;
    private String msisdn;
    private String adresse;
    private Gestionaire gestionaire;

}
