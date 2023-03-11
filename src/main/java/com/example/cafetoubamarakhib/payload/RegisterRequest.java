package com.example.cafetoubamarakhib.payload;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String login;
}
