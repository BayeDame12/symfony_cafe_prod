package com.example.cafetoubamarakhib.repository;

import com.example.cafetoubamarakhib.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {
<<<<<<< HEAD
    Optional<Personne> findByUsername(String login);

=======
    Optional<Personne> findByUsername(String username);
>>>>>>> 78a785adef2999783d32f3dfccd2e6584bb00664
}
