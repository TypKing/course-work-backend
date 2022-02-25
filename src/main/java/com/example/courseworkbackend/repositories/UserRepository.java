package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
