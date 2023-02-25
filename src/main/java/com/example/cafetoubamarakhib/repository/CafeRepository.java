package com.example.cafetoubamarakhib.repository;

import com.example.cafetoubamarakhib.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeRepository extends JpaRepository<Cafe,Long> {

}
