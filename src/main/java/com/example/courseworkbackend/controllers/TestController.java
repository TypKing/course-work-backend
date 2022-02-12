package com.example.courseworkbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/get")
    public String getString(){
        return new String("Привет, пидорас. Все работает!");
    }

}
