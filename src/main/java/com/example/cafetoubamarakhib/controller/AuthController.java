package com.example.cafetoubamarakhib.controller;

import com.example.cafetoubamarakhib.payload.AuthenticationResponse;
import com.example.cafetoubamarakhib.payload.LoginRequest;
import com.example.cafetoubamarakhib.payload.RegisterRequest;
import com.example.cafetoubamarakhib.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {


        System.out.println("dkjsfkjs");

        return authService.login(loginRequest);
    }
}
