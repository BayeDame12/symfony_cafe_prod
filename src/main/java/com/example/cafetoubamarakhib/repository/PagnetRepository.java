package com.example.cafetoubamarakhib.repository;

import com.example.cafetoubamarakhib.model.Pagnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagnetRepository extends JpaRepository<Pagnet,Long> {
}
