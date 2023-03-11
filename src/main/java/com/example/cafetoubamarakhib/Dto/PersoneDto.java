package com.example.cafetoubamarakhib.Dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PersoneDto {
    private Long id;
    private String username;
    private String nom;
<<<<<<< HEAD
    private String password;
    private String login;
=======

    @Override
    public String toString() {
        return "PersoneDto{" +
                "id=" + id +
                ", prenom='" + username + '\'' +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

>>>>>>> 78a785adef2999783d32f3dfccd2e6584bb00664
    private String type;

}
