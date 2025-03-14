package com.example.myapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usertable {
    @Id
    private String username;
    private String password;
    private String role;
}