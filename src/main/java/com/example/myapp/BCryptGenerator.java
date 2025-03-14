package com.example.myapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);
    }
}
