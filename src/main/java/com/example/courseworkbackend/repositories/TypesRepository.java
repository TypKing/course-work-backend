package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepository extends JpaRepository<Types, Long> {
}
