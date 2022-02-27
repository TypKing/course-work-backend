package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
