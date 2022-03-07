package com.example.courseworkbackend.controllers;

import com.example.courseworkbackend.entities.User;
import com.example.courseworkbackend.entities.dao.requests.UserD;
import com.example.courseworkbackend.entities.dao.responses.LoginResponse;
import com.example.courseworkbackend.repositories.CoordinateRepository;
import com.example.courseworkbackend.repositories.UserRepository;
import com.example.courseworkbackend.services.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private CoordinatorService coordinatorService;
    @Autowired
    private CoordinateRepository coordinateRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse getString(@RequestBody UserD userD){
        System.out.println(userD.toString());
        User user = userRepository.findUserByLogin(userD.getLogin());
        if (user.getPassword() == userD.getPassword())
            return new LoginResponse().setFlag(true).setRole(user.getRole());
        else
            return new LoginResponse().setFlag(false);
    }
    @GetMapping(name = "/get")
    public String getMess(){
        return new String("Sosi");
    }


//    @GetMapping(value = "/get/{id}")
//    public LoginResponse getUserById(@RequestParam Long id){
//        User user = userRepository.findById(id);
//    }

}
