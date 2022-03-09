package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Employee;
import com.example.courseworkbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByLogin(String login);
    public void deleteUserByEmployee(Employee employee);
}
