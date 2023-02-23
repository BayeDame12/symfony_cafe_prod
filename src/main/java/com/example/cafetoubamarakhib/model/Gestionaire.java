package com.example.cafetoubamarakhib.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table
public class Gestionaire extends Personne {
    private String login;
    private String password;
    @OneToMany(
            mappedBy = "gestionaire",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Client>clients =new ArrayList<>();
    @OneToMany(
            mappedBy = "gestionaire",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Stock>stocks =new ArrayList<>();
    @OneToMany(
            mappedBy = "gestionaire",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Cafe>cafes =new ArrayList<>();

    @Override
    public String toString() {
        return "Gestionaire{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", clients=" + clients +
                ", stocks=" + stocks +
                ", cafes=" + cafes +
                '}';
    }
}
