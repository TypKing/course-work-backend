package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Employee;
import com.example.courseworkbackend.entities.Human;
import com.example.courseworkbackend.entities.User;
import com.example.courseworkbackend.exceptions.NotFoundException;
import com.example.courseworkbackend.exceptions.UserIsAlreadyExist;
import com.example.courseworkbackend.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private HumanRepository humanRepository;
    private CountryRepository countryRepository;
    private PositionRepository positionRepository;
    private UserRepository userRepository;


    @Transactional
    public boolean addNewEmployee(
                String firstName,
                String lastName,
                Timestamp birthday,
                Long id_country,
                Long id_position,
                Integer experience,
                Integer accessLevel,
                Timestamp startTime,
                Timestamp endTime,
                String login,
                String password){

        Human human = createHuman(firstName, lastName, birthday, id_country);
        Employee employee = createEmployee(human, id_position, experience, accessLevel, startTime, endTime);

        if (userRepository.findUserByLogin(login) == null){
            userRepository.save(
                    new User()
                            .setLogin(login)
                            .setPassword(password)
                            .setEmployee(employee));
            return true;
        }
        else return false;

    }


    @Transactional
    public boolean addExistEmployee(
            Long id_human,
            Long id_position,
            Integer experience,
            Integer accessLevel,
            Timestamp startTime,
            Timestamp endTime,
            String login,
            String password){

        Human human = humanRepository.getById(id_human);
        Employee employee = createEmployee(human, id_position, experience, accessLevel, startTime, endTime);

        if (userRepository.findUserByLogin(login) == null){
            userRepository.save(
                    new User()
                            .setLogin(login)
                            .setPassword(password)
                            .setEmployee(employee));
            return true;
        }
        else return false;

    }

    @Transactional
    Human createHuman(
            String firstName,
            String lastName,
            Timestamp birthday,
            Long id_country
    ){
        Human human = new Human()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthday(birthday)
                .setCountryId(countryRepository.getById(id_country));

        if (!humanRepository.existsHumanByFirstNameAndLastNameAndBirthday(human)){
            humanRepository.save(human);
            return human;
        }
        else {
            return null;
        }
    }

    @Transactional
    Employee createEmployee(
            Human human,
            Long id_position,
            Integer experience,
            Integer accessLevel,
            Timestamp startTime,
            Timestamp endTime
    ){
        Employee employee = new Employee()
                .setHuman(human)
                .setPosition(
                        positionRepository.getById(id_position)
                )
                .setExperience(experience)
                .setAccessLevel(accessLevel)
                .setStartTime(startTime)
                .setEndTime(endTime);
        return  employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        Employee employee = employeeRepository.getById(id);
        if (employee.getAccessLevel() < 10) employeeRepository.deleteById(id);
    }
}
