package com.example.courseworkbackend.controllers;


import com.example.courseworkbackend.services.ComponentLoaderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController("/loader")
public class ComponentLoadController {

    private ComponentLoaderService componentLoaderService;

    @GetMapping("/getCountryMap")
    public Map<Long, String> getCountryMap(){
        return componentLoaderService.getCountriesMap();
    }

}
