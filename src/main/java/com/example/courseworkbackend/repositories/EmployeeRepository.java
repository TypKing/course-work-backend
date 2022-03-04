package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //List<Employee> findAllById(Iterable<Long> longs);
}
