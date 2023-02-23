package com.example.cafetoubamarakhib.Dto;

import lombok.Data;
@Data
public class PersoneDto {
    private Long id;
    private String prenom;
    private String nom;

    @Override
    public String toString() {
        return "PersoneDto{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String type;

}
