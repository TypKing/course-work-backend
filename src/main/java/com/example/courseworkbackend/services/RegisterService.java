package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.*;
import com.example.courseworkbackend.repositories.ArtifactRepository;
import com.example.courseworkbackend.repositories.MonsterRepository;
import com.example.courseworkbackend.repositories.RiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RiftRepository riftRepository;
    private final MonsterRepository monsterRepository;
    private final ArtifactRepository artifactRepository;

    public void addRift(Rift rift) {
        riftRepository.save(rift);
    }

    public void addMonster(Monster monster) {
        monsterRepository.save(monster);
    }

    public void addArtifact(Artifact artifact) {
        artifactRepository.save(artifact);
    }

    public void setMonsterTypeById(Long id, Types type) {
        monsterRepository.updateMonsterType(id, type);
    }


}
