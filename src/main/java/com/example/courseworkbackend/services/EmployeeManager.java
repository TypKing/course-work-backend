package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Employee;
import com.example.courseworkbackend.repositories.EmployeeRepository;
import com.example.courseworkbackend.repositories.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeManager {

    private EmployeeRepository employeeRepository;
    private HumanRepository humanRepository;

    public void addEmployee(Employee employee){
        humanRepository.save(employee.getHuman());
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        Employee employee = employeeRepository.getById(id);
        if (employee.getAccessLevel() < 10) employeeRepository.deleteById(id);
    }
}
