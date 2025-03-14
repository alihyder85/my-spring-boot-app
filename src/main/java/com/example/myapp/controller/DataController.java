package com.example.myapp.controller;

import com.example.myapp.model.DataModel;
import com.example.myapp.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/data")
    public ResponseEntity<List<DataModel>> getData() {
        return ResponseEntity.ok(dataRepository.findAll());
    }

    @GetMapping("/data/{id}")
    public DataModel getDataById(@PathVariable Long id) {
        return dataRepository.findById(id).orElse(null);
    }

    @PostMapping("/data")
    public ResponseEntity<DataModel> addData(@RequestBody DataModel data) {
        DataModel createData = dataRepository.save(data);
        //return ResponseEntity.created(URI.create("/data/" + createData.getId())).body(createData);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                              .path("/{id}")
                                              .buildAndExpand(createData.getId())
                                              .toUri();
        return ResponseEntity.created(location).body(createData);
    }
}   