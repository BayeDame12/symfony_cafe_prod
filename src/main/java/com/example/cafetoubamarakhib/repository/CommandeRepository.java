package com.example.cafetoubamarakhib.repository;

import com.example.cafetoubamarakhib.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
