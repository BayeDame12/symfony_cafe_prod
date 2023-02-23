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
public class Pagnet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(
            mappedBy = "pagnet",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Commande> commandes =new ArrayList<>();

    @Override
    public String toString() {
        return "Pagnet{" +
                "id=" + id +
                ", commandes=" + commandes +
                '}';
    }
}
