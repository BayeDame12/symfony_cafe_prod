package com.example.cafetoubamarakhib.repository;

import com.example.cafetoubamarakhib.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
