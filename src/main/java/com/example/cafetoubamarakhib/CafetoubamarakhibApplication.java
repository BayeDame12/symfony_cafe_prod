package com.example.cafetoubamarakhib;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class CafetoubamarakhibApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafetoubamarakhibApplication.class, args);
        System.out.println("TOUBA DIALIBATOUL MARAKHIB");

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

<<<<<<< HEAD
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
=======

>>>>>>> 78a785adef2999783d32f3dfccd2e6584bb00664
}
