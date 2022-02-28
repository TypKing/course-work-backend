package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
}
