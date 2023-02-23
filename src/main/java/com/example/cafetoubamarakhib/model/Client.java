package com.example.cafetoubamarakhib.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table
public class Client extends Personne {
    private String msisdn;
    private String adresse;


  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "gestionaire_id")

    private Gestionaire gestionaire;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Commande>commandes =new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "msisdn='" + msisdn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", gestionaire=" + gestionaire +
                ", commandes=" + commandes +
                '}';
    }
}
