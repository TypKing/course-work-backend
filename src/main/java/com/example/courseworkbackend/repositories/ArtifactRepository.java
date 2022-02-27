package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
}
