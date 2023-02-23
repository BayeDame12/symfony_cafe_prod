package com.example.cafetoubamarakhib.Dto;

public class GestionaireDto extends PersoneDto{
    private String login;
    private String password;

    @Override
    public String toString() {
        return "GestionaireDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
