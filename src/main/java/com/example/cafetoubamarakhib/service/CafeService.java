package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Cafe;
import com.example.cafetoubamarakhib.model.Client;

import java.util.List;

public interface CafeService {
    List<Cafe> getAllCafe();

    Cafe addCafe(Cafe cafe);

    Cafe updateCafe(long id, Cafe cafe);

    void deleteCafe(long id);

    Cafe getCafeById(long id);
}
