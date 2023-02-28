package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Personne;
import com.example.cafetoubamarakhib.repository.PersonneRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    private final PersonneRepository personneRepository;

    public UserDetailsServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne personne= personneRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("No user found"+ username));
        return new org.springframework.security.core.userdetails.User(personne.getUsername(), personne.getPassword(), true, true, true, true, getAutorities("ROLE8USER"));
    }

    private Collection<? extends GrantedAuthority> getAutorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
}
