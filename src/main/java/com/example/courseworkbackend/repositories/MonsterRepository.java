package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
