package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Artifact;
import com.example.courseworkbackend.entities.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {

    @Query(value = "select * from list_artifacts(cast(? as bigint))", nativeQuery = true)
    public List<Artifact> getListArtifacts(Long riftId);
}
