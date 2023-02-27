package com.example.cafetoubamarakhib.Dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PersoneDto {
    private Long id;
    private String username;
    private String nom;
    private String password;
    private String login;
    private String type;

}
