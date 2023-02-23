package com.example.cafetoubamarakhib.controller;

import com.example.cafetoubamarakhib.service.CafeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafeController {
    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }
}
