package com.example.cafetoubamarakhib.Dto;

import lombok.Data;

@Data
public class CafeDto {
    private Long id;
    private String nom;
    private String description;
    private String image;
    private int quantity;
    private int prix;

    @Override
    public String toString() {
        return "CafeDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", prix=" + prix +
                '}';
    }
}
