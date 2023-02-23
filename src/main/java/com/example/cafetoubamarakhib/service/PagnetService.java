package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Cafe;
import com.example.cafetoubamarakhib.model.Pagnet;

import java.util.List;

public interface PagnetService {
    List<Pagnet> getAllPagnet();
    Pagnet addPagnet(Pagnet pagnet);
    Pagnet updatePagnet(long id,Pagnet pagnet);
    void deletePagnet(long id);
    Pagnet getPagnetById(long id);
}
