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
    private  RiftRepository riftRepository;
    @Autowired
    private  MonsterRepository monsterRepository;
    @Autowired
    private  ArtifactRepository artifactRepository;
    @Autowired
    private  CoordinateRepository coordinateRepository;
    @Autowired
    private  CountryRepository countryRepository;
    @Autowired
    private  TypesRepository typesRepository;

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




    public void closeRift(){

    }

    public void changeStatus(){

    }

    public void setArtifactOrMonsterType(String name, String description, String classType){
        typesRepository.save(
            new Types()
                    .setName(name)
                    .setDescription(description)
                    .setClass_type(ClassType.getClassType(classType)));
    }



    public void addMonster(Long id_type, Long id_rift, Integer rank){
        Monster monster = new Monster().setTypes(typesRepository.getById(5L)).setDetection_rift(riftRepository.getById(1L)).setRank(1);
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
        artifactRepository.save(artifact);
    }

    public void setMonsterTypeById(Long id, Long id_type) {
        monsterRepository.updateMonsterType(id, typesRepository.getById(id_type));
    }


}
