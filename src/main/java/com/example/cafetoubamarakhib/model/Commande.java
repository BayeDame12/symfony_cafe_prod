package com.example.cafetoubamarakhib.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String contenu;
    private int prix;
    private String numeroCommande;
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")

    private Client client;

    @OneToMany(
            mappedBy = "commande",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Cafe>cafes =new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagnet_id")

    private Pagnet pagnet;

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", contenu='" + contenu + '\'' +
                ", prix=" + prix +
                ", numeroCommande='" + numeroCommande + '\'' +
                ", date=" + date +
                ", client=" + client +
                ", cafes=" + cafes +
                '}';
    }
}
