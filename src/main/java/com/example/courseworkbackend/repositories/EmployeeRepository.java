package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Employee;
import com.example.courseworkbackend.entities.Guild;
import com.example.courseworkbackend.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> getEmployeeByGuild(Guild guild);
    public Employee findByHuman(Human human);
}
