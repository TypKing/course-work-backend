package com.example.courseworkbackend.controllers;


import com.example.courseworkbackend.entities.dao.responses.CitiesR;
import com.example.courseworkbackend.services.ComponentLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
public class ComponentLoadController {

    @Autowired
    private ComponentLoaderService componentLoaderService;

    @GetMapping("/getCountryMap")
    public List<CitiesR> getCountryMap(){
        return componentLoaderService.getCountriesMap();
    }

}
