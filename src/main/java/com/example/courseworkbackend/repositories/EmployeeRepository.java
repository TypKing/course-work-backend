package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
