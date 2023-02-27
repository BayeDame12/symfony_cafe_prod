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
    private String username;
    @Column
    private String nom;
    @Column
    private String type;
    @Column
    private String login;
    @Column
    private String password;

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", prenom='" + username + '\'' +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
