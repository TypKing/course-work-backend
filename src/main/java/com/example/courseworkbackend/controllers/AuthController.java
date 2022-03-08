package com.example.courseworkbackend.controllers;

import com.example.courseworkbackend.entities.User;
import com.example.courseworkbackend.entities.dao.requests.EmployeeD;
import com.example.courseworkbackend.repositories.CoordinateRepository;
import com.example.courseworkbackend.repositories.UserRepository;
import com.example.courseworkbackend.services.CoordinatorService;
import com.example.courseworkbackend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@CrossOrigin
@RestController
public class AuthController {

    @Autowired
    private CoordinatorService coordinatorService;
    @Autowired
    private CoordinateRepository coordinateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeService employeeService;

    private HashMap<String, String> responseMap;


    @PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> userAuth(@RequestBody EmployeeD employeeD){
        System.out.println("Проверку проходит пользователь: " + employeeD.getLogin());
        User userWithSameLogin = userRepository.findUserByLogin(employeeD.getLogin());
        if (userWithSameLogin != null && Objects.equals(userWithSameLogin.getPassword(), employeeD.getPassword())){
            responseMap.put("result", "true");
            responseMap.put("role", userWithSameLogin.getEmployee().getPosition().getPosition_name());
        }
        else{
            responseMap.put("result", "false");
            responseMap.put("role", null);

        }

        return responseMap;
    }


    /*
    return {
        @result
        @user-login
        @password-login
    }
     */

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> userRegistration(@RequestBody EmployeeD employeeD) {
        responseMap = new HashMap<>();
        System.out.println("Проверку проходит регистрацию: " + employeeD.getLogin());
        System.out.println(employeeD.toString());
        boolean result = false;

        if (employeeD.getId_human() == null) {
            result = employeeService.addNewEmployee(
                    employeeD.getFirstName(),
                    employeeD.getLastName(),
                    employeeD.getBirthday(),
                    employeeD.getCountryId(),
                    employeeD.getPositionId(),
                    employeeD.getExperience(),
                    employeeD.getAccessLevel(),
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    employeeD.getLogin(),
                    employeeD.getPassword()
            );
        } else {
           result = employeeService.addExistEmployee(
                    employeeD.getId_human(),
                    employeeD.getPositionId(),
                    employeeD.getExperience(),
                    employeeD.getAccessLevel(),
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    employeeD.getLogin(),
                    employeeD.getPassword());
        }

        responseMap.put("login", employeeD.getLogin());
        responseMap.put("password", employeeD.getPassword());
        responseMap.put("position", employeeService.getPositionNameById(employeeD.getPositionId()));
        responseMap.put("result", result? "true":"false");
        return responseMap;
    }


}
