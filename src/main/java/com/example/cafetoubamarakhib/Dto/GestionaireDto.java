package com.example.cafetoubamarakhib.Dto;

public class GestionaireDto extends PersoneDto{
    private Long id;
    private String login;
    private String password;

    @Override
    public String toString() {
        return "GestionaireDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
