package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Rift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiftRepository extends JpaRepository<Rift, Long> {
}
