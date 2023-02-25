package com.example.cafetoubamarakhib.Dto;

import com.example.cafetoubamarakhib.model.Gestionaire;
import lombok.Data;

public class ClientDto extends PersoneDto{
    private Long id;
    private String msisdn;

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", msisdn='" + msisdn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", gestionaire=" + gestionaire +
                '}';
    }

    private String adresse;
    private Gestionaire gestionaire;

}
