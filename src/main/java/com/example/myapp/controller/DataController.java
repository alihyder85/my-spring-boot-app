package com.example.myapp.controller;

import com.example.myapp.model.DataModel;
import com.example.myapp.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/data")
    public List<DataModel> getData() {
        return dataRepository.findAll();
    }

    @GetMapping("/data/{id}")
    public DataModel getDataById(@PathVariable Long id) {
        return dataRepository.findById(id).orElse(null);
    }
}