package com.example.cafetoubamarakhib.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String description;
    private int quantity;
    private int prix;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gestionaire_id")

    private Gestionaire gestionaire;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commande_id")

    private Commande commande;

    @Override
    public String toString() {
        return "Cafe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", prix=" + prix +
                ", gestionaire=" + gestionaire +
                ", commande=" + commande +
                '}';
    }
}
