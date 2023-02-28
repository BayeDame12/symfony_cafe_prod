package com.example.cafetoubamarakhib.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {
    private static final String SECRET_KEY = "salam";

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder().setSubject(principal.getUsername()).signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes()).compact();
    }

    public boolean validateToken(String jwt) {
        Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(jwt);
        return true;
    }

    public String getUsernameFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody();

        return claims.getSubject();
    }
}
