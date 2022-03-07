package com.example.courseworkbackend.controllers;

import com.example.courseworkbackend.repositories.CoordinateRepository;
import com.example.courseworkbackend.services.CoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private CoordinatorService coordinatorService;
    @Autowired
    private CoordinateRepository coordinateRepository;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getString(){
        return coordinateRepository.findAll().toString();
    }

}
