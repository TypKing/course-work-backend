package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.*;
import com.example.courseworkbackend.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RiftRepository riftRepository;
    private final MonsterRepository monsterRepository;
    private final ArtifactRepository artifactRepository;
    private final CoordinateRepository coordinateRepository;
    private final CountryRepository countryRepository;
    private final TypesRepository typesRepository;

    public void addRift(Long id_coordinate, Long id_country, Integer rank,
                        Integer accessLevel, Integer reward) {
        riftRepository.save(
                new Rift()
                        .setCoordinate(coordinateRepository.getById(id_coordinate))
                        .setCountry(countryRepository.getById(id_country))
                        .setRank(rank)
                        .setAccessLevel(accessLevel)
                        .setReward(reward)
        );
    }

    public void addMonster(Long id_type, Long id_rift, Integer rank){
        monsterRepository.save(
                new Monster()
                        .setTypes(typesRepository.getById(id_type))
                        .setDetection_rift(riftRepository.getById(id_rift))
                        .setRank(rank)
        );
    }

    public void addArtifact(Long id_type, Long id_rift, Integer price) {
        artifactRepository.save(
                new Artifact()
                        .setType(typesRepository.getById(id_type))
                        .setDetection_rift(riftRepository.getById(id_rift))
                        .setPrice(price)
        );
    }

    public void setMonsterTypeById(Long id, Long id_type) {
        monsterRepository.updateMonsterType(id, typesRepository.getById(id_type));
    }


}
