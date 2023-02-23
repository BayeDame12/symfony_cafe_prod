package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Cafe;
import com.example.cafetoubamarakhib.model.Commande;
import com.example.cafetoubamarakhib.repository.CafeRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeServiceImpl implements CafeService{
    private final CafeRepository cafeRepository;

    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Override
    public List<Cafe> getAllCafe() {
        return cafeRepository.findAll();
    }

    @Override
    public Cafe addCafe(Cafe cafe) {
        return cafeRepository.save(cafe);
    }

    @Override
    public Cafe updateCafe(long id, Cafe cafeRequest) {
        Cafe cafe=cafeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("le cafe que vous chercher n existe pas"));
        cafe.setPrix(cafeRequest.getPrix());
        cafe.setNom(cafeRequest.getNom());
        cafe.setDescription(cafeRequest.getDescription());
        cafe.setQuantity(cafeRequest.getQuantity());
        return cafeRepository.save(cafe);
    }

    @Override
    public void deleteCafe(long id) {
        Cafe cafe=cafeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("la Cafe que vous chercher n existe pas"));
         cafeRepository.delete(cafe);

    }

    @Override
    public Cafe getCafeById(long id) {
        {
            Optional<Cafe> result=cafeRepository.findById(id);
            if (result.isPresent()){
                return result.get();
            }
            else {
                throw new ResourceNotFoundException("la Cafe que vous chercher n existe pas");
            }
        }
    }
}
