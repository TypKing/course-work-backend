package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.*;
import com.example.courseworkbackend.entities.dao.responses.*;
import com.example.courseworkbackend.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private RiftStatusRepository riftStatusRepository;

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

    public List<RiftR> getRiftListByEmployeeId(Long id){
        List<Rift> list = riftRepository.getListRiftByIdEmployeeAccessLevel(id);
        List<RiftR> listN = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Rift rift : list) {
                listN.add(
                        new RiftR()
                                .setId(rift.getId())
                                .setCoordinateX(rift.getCoordinate().getLatitude().toString())
                                .setCoordinateY(rift.getCoordinate().getLongitude().toString())
                                .setRank(rift.getRank())
                                .setAccessLevel(rift.getAccessLevel())
                                .setReward(rift.getReward())
                );
            }
        }
        return listN;
    }

    public List<RiftR> getListRiftByGroupAndCountry(Long groupId, Long countryId){
        List<Rift> list = riftRepository.getListRiftByGroupAndCountry(groupId, countryId);
        List<RiftR> listN = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Rift rift : list) {
                listN.add(
                        new RiftR()
                                .setId(rift.getId())
                                .setCoordinateX(rift.getCoordinate().getLatitude().toString())
                                .setCoordinateY(rift.getCoordinate().getLongitude().toString())
                                .setRank(rift.getRank())
                                .setAccessLevel(rift.getAccessLevel())
                                .setReward(rift.getReward())
                );
            }
        }
        return listN;
    }

    public List<RiftR> getRiftList(Long countryId){
        List<Rift> list = riftRepository.findAll();
        List<RiftR> riftN = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Rift rift : list) {
                if (rift.getCountry().getId_country().equals(countryId)){
                    riftN.add(
                            new RiftR()
                                    .setId(rift.getId())
                                    .setCoordinateX(rift.getCoordinate().getLatitude().toString())
                                    .setCoordinateY(rift.getCoordinate().getLongitude().toString())
                                    .setRank(rift.getRank())
                                    .setAccessLevel(rift.getAccessLevel())
                                    .setReward(rift.getReward()));
                }
            }
        }
        return riftN;
    }

    public List<RiftStatusR> getListRiftStatusesByRiftId(Long id){
//        List<RiftStatus> list = riftStatusRepository.getAllById_rift(id);
        List<RiftStatus> list = riftStatusRepository.findAll();
        List<RiftStatusR> riftN = new ArrayList<>();
        if (!list.isEmpty()) {
            for (RiftStatus riftStatus : list) {
                if (riftStatus.getId_rift().getId().equals(id)){
                    riftN.add(
                            new RiftStatusR()
                                    .setId(riftStatus.getId())
                                    .setGroupName(riftStatus.getGroup_id().getName())
                                    .setTime(riftStatus.getTime())
                                    .setOpenTime(riftStatus.getTime_to_open())
                                    .setResult(riftStatus.isResult())
                                    .setRiftCondition(riftStatus.isRift_condition())
                    );
                }

            }
        }
        return riftN;
    }


    public List<MonsterR> getMonsterList(Long riftId){
        List<Monster> list = monsterRepository.getListMonsters(riftId);
        List<MonsterR> listN = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Monster monster : list) {
                listN.add(
                        new MonsterR()
                                .setMonsterId(monster.getId_monster())
                                .setRank(monster.getRank())
                                .setTypeName(monster.getTypes().getName()));
            }
        }
        return listN;
    }

    public List<ArtifactR> getArtifactList(Long riftId){
        List<Artifact> list = artifactRepository.getListArtifacts(riftId);
        List<ArtifactR> listN = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Artifact artifact : list) {
                listN.add(
                        new ArtifactR()
                                .setArtifactId(artifact.getId_artifact())
                                .setPrice(artifact.getPrice())
                                .setTypeName(artifact.getType().getName()));
            }
        }
        return listN;
    }

    public List<MaterialR> getMaterialList(Long riftId){
        List<Material> list = materialRepository.getListMaterials(riftId);
        List<MaterialR> listN = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Material material : list) {
                listN.add(
                        new MaterialR()
                                .setMaterialId(material.getId_material())
                                .setPrice(material.getPrice())
                                .setName(material.getName()));
            }
        }
        return listN;
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
