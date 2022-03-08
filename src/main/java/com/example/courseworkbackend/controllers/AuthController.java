package com.example.courseworkbackend.controllers;

import com.example.courseworkbackend.entities.User;
import com.example.courseworkbackend.entities.dao.requests.EmployeeD;
import com.example.courseworkbackend.repositories.CoordinateRepository;
import com.example.courseworkbackend.repositories.UserRepository;
import com.example.courseworkbackend.services.CoordinatorService;
import com.example.courseworkbackend.services.EmployeeService;
import org.jetbrains.annotations.NotNull;
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

    private HashMap<String, String> map;

    /*
    return {
        @access
        @role
    }
     */

//    @PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, String> userAuth(@RequestBody EmployeeD userD) {
//        map = new HashMap<>();
//        System.out.println("Проверку проходит пользователь: " + userD.getLogin());
//        User userWithSameLogin = userRepository.findUserByLogin(userD.getLogin());
//        if (userWithSameLogin != null && Objects.equals(userWithSameLogin.getPassword(), userD.getPassword())) {
//            map.put("access", "true");
//            map.put("role", userWithSameLogin.getRole());
//        } else {
//            map.put("access", "false");
//            map.put("role", null);
//
//        }
//        return map;
//    }

//    @PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> userAuth(@RequestBody UserD userD){
//        List<JSONObject>
//        System.out.println("Проверку проходит пользователь: " + userD.getLogin());
//        User userWithSameLogin = userRepository.findUserByLogin(userD.getLogin());
//        if (userWithSameLogin != null && Objects.equals(userWithSameLogin.getPassword(), userD.getPassword())){
//            map.put("access", "true");
//            map.put("role", userWithSameLogin.getRole());
//        }
//        else{
//            map.put("access", "false");
//            map.put("role", null);
//
//        }
//        return map;
//    }


    /*
    return {
        @result
        @user-login
        @password-login
    }
     */

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> userRegistration(@RequestBody EmployeeD employeeD) {
        map = new HashMap<>();
        System.out.println("Проверку проходит регистрацию: " + employeeD.getLogin());
        System.out.println(employeeD.toString());
        boolean access = false;

        if (employeeD.getId_human() == null) {
            access = employeeService.addNewEmployee(
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
           access = employeeService.addExistEmployee(
                    employeeD.getId_human(),
                    employeeD.getPositionId(),
                    employeeD.getExperience(),
                    employeeD.getAccessLevel(),
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis()),
                    employeeD.getLogin(),
                    employeeD.getPassword());
        }

        map.put("login", employeeD.getLogin());
        map.put("password", employeeD.getPassword());
        map.put("position", employeeService.getPositionNameById(employeeD.getPositionId()));
        map.put("access", access? "true":"false");
        return map;
    }


}
