package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.*;
import com.example.courseworkbackend.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    @Autowired
    private final RiftRepository riftRepository;
    @Autowired
    private final MonsterRepository monsterRepository;
    @Autowired
    private final ArtifactRepository artifactRepository;
    @Autowired
    private final CoordinateRepository coordinateRepository;
    @Autowired
    private final CountryRepository countryRepository;
    @Autowired
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

    public void setArtifactOrMonsterType(String name, String description, String classType){
        typesRepository.save(
            new Types()
                    .setName(name)
                    .setDescription(description)
                    .setClass_type(ClassType.getClassType(classType)));
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
        Artifact artifact = new Artifact()
                .setType(typesRepository.getById(id_type))
                .setRift(riftRepository.getById(id_rift))
                .setPrice(price);
        System.out.println(artifact.toString() + " - СОСТОЯНИЕ ПЕРЕД ДОБАВЛЕНИЕМ В БД");
        artifactRepository.save(artifact);
    }

    public void setMonsterTypeById(Long id, Long id_type) {
        monsterRepository.updateMonsterType(id, typesRepository.getById(id_type));
    }


}
