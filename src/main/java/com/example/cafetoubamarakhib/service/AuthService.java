package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Personne;
import com.example.cafetoubamarakhib.payload.AuthenticationResponse;
import com.example.cafetoubamarakhib.payload.LoginRequest;
import com.example.cafetoubamarakhib.payload.RegisterRequest;
import com.example.cafetoubamarakhib.repository.PersonneRepository;
import com.example.cafetoubamarakhib.security.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final PersonneRepository personneRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    public AuthService(PersonneRepository personneRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.personneRepository = personneRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    public void signup(RegisterRequest registerRequest) {
        Personne personne = new Personne();
        personne.setUsername(registerRequest.getUsername());
        personne.setPassword(encodePassword(registerRequest.getPassword()));
        personne.setLogin(registerRequest.getLogin());

        personneRepository.save(personne);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public AuthenticationResponse login(LoginRequest loginRequest ) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(authenticationToken, loginRequest.getUsername());
    }


    public Optional<User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
}
