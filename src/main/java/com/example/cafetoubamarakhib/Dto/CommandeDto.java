package com.example.cafetoubamarakhib.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommandeDto {
    private Long id;
    private String contenu;
    private int prix;
    private String numeroCommande;
    private Date date;

    @Override
    public String toString() {
        return "CommandeDto{" +
                "id=" + id +
                ", contenu='" + contenu + '\'' +
                ", prix=" + prix +
                ", numeroCommande='" + numeroCommande + '\'' +
                ", date=" + date +
                '}';
    }
}
