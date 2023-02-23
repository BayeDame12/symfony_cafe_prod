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
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String prenom;
    @Column
    private String nom;
    @Column
    private String type;

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", prenom='" + prenom + '\'' + ", nom='" + nom + '\'' + '}';
    }
}
