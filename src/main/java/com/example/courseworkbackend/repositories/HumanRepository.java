package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human, Long> {
}
