package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Employee;
import com.example.courseworkbackend.entities.Human;
import com.example.courseworkbackend.repositories.CountryRepository;
import com.example.courseworkbackend.repositories.EmployeeRepository;
import com.example.courseworkbackend.repositories.HumanRepository;
import com.example.courseworkbackend.repositories.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private HumanRepository humanRepository;
    private CountryRepository countryRepository;
    private PositionRepository positionRepository;

    public void addEmployee(
                String firstName,
                String lastName,
                Timestamp birthday,
                Long id_country,
                Long id_position,
                Integer experience,
                Integer accessLevel,
                Timestamp startTime,
                Timestamp endTime){

        Human human = new Human()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthday(birthday)
                .setCountryId(countryRepository.getById(id_country));
        humanRepository.save(human);

        employeeRepository.save(new Employee()
                .setHuman(human)
                .setPosition(
                        positionRepository.getById(id_position)
                )
                .setExperience(experience)
                .setAccessLevel(accessLevel)
                .setStartTime(startTime)
                .setEndTime(endTime)
        );
    }

    public void deleteEmployee(Long id){
        Employee employee = employeeRepository.getById(id);
        if (employee.getAccessLevel() < 10) employeeRepository.deleteById(id);
    }
}
