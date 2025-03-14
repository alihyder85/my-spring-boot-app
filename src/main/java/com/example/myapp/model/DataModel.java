
package com.example.myapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DataModel {
    @Id
    private Long id;
    private String name;
    private String description;

}