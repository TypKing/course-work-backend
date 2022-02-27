package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
