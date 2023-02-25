package com.example.cafetoubamarakhib.controller;

import com.example.cafetoubamarakhib.Dto.CafeDto;
import com.example.cafetoubamarakhib.Dto.CommandeDto;
import com.example.cafetoubamarakhib.model.Cafe;
import com.example.cafetoubamarakhib.model.Commande;
import com.example.cafetoubamarakhib.service.CafeService;
import com.example.cafetoubamarakhib.service.mapper.CafeMapStruct;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@RestController
@RequestMapping("/api/cafe")
@CrossOrigin(origins = "", allowedHeaders = "*")
public class CafeController {
    private final CafeService cafeService;
    private final CafeMapStruct cafeMapStruct;
    private final ModelMapper modelMapper;

    public CafeController(CafeService cafeService, CafeMapStruct cafeMapStruct, ModelMapper modelMapper) {
        this.cafeService = cafeService;
        this.cafeMapStruct = cafeMapStruct;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CafeDto> getAllCafe() {
        return cafeService.getAllCafe().stream().map(cafe -> modelMapper.map(cafe, CafeDto.class)).collect(Collectors.toList());

    }

    //**************RECUPERER UN UTILISATEUR APARTIR DE SON IDENTIFIANT******************************
    @GetMapping("/{id}")
    public ResponseEntity<CafeDto> getCafeById(@PathVariable(name = "id") Long id) {
        Cafe cafe = cafeService.getCafeById(id);
        CafeDto postResponse = cafeMapStruct.toDto(cafe);
        return ResponseEntity.ok().body(postResponse);

    }
    //*************************UPDATE UTILISATEUR******************************

    @PutMapping("/{id}")
    public ResponseEntity<CafeDto> updateCafe(@PathVariable Long id, @RequestBody CafeDto cafeDto) {
        Cafe cafeRequest = cafeMapStruct.toEntity(cafeDto);
        Cafe cafe = cafeService.updateCafe(id, cafeRequest);
        CafeDto cafeResponse = cafeMapStruct.toDto(cafe);
        return ResponseEntity.ok().body(cafeResponse);
    }

    @PostMapping
    public ResponseEntity<CafeDto> saveCafe(@RequestBody CafeDto cafeDto) {
        Cafe cafeRequest = cafeMapStruct.toEntity(cafeDto);
        Cafe cafe = cafeService.addCafe(cafeRequest);
        CafeDto cafeResponse = cafeMapStruct.toDto(cafe);
        return ResponseEntity.ok().body(cafeDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCafe(@PathVariable(name = "id") Long id) {
        cafeService.deleteCafe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
