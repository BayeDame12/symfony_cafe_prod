package com.example.cafetoubamarakhib.Dto;

import lombok.Data;
@Data
public class PersoneDto {
    private Long id;
    private String username;
    private String nom;

    @Override
    public String toString() {
        return "PersoneDto{" +
                "id=" + id +
                ", prenom='" + username + '\'' +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String type;

}
