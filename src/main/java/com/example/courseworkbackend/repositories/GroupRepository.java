package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}