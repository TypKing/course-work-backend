package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.RiftStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiftStatusRepository extends JpaRepository<RiftStatus, Long> {
//    List<RiftStatus> getAllById_rift(Long id);
}
