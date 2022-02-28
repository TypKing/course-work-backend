package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Awakener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwakenerRepository extends JpaRepository<Awakener, Long> {
}
