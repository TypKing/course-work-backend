package com.example.courseworkbackend.controllers;

import com.example.courseworkbackend.entities.*;
import com.example.courseworkbackend.entities.dao.requests.*;
import com.example.courseworkbackend.entities.dao.responses.RecyclingCenterR;
import com.example.courseworkbackend.services.AwakenerService;
import com.example.courseworkbackend.services.CoordinatorService;
import com.example.courseworkbackend.services.RcManagerService;
import com.example.courseworkbackend.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class AppController {

    @Autowired
    private AwakenerService awakenerService;

    @Autowired
    private CoordinatorService coordinatorService;

    @Autowired
    private RcManagerService rcManagerService;

    @Autowired
    private RegisterService registerService;

    private HashMap<String, String> responseMap;

    @PostMapping(value = "/addAwakener", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> userAuth(@RequestBody AwakenerD awakenerD){
        responseMap = new HashMap<>();
        boolean result = false;
        System.out.println();
        System.out.println("Добавление проходит пробужденный: " + awakenerD.getFirstName());
        if (awakenerService.addAwakener(awakenerD.getFirstName(), awakenerD.getLastName(), awakenerD.getBirthday(),
                awakenerD.getCountryId(), awakenerD.getId_guild(), awakenerD.getRank(), awakenerD.getExperience(),
                awakenerD.getAwakeTime())){
            result = true;
        }
        responseMap.put("result", Boolean.toString(result));
        return responseMap;
    }

    @DeleteMapping(value = "/deleteAwakener/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> deleteAwakener(@PathVariable(value = "id") Long awakenerId) {
        responseMap = new HashMap<>();
        try {
            awakenerService.deleteAwakener(awakenerId);
            responseMap.put("result", "true");
            return responseMap;
        } catch (Exception e){
            responseMap.put("result", "false");
            return responseMap;
        }


    }

    @GetMapping(value = "/getAwakenerInfo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AwakenerD getAwakenerInfoById(@PathVariable(value = "id") Long awakenerId){
        responseMap = new HashMap<>();
        Awakener awakener = awakenerService.getInfoById(awakenerId);
        if (awakener != null){
            return new AwakenerD()
                    .setFirstName(awakener.getHuman().getFirstName())
                    .setLastName(awakener.getHuman().getLastName())
                    .setRank(awakener.getRank())
                    .setAwakeTime(awakener.getAwakeTime())
                    .setBirthday(awakener.getHuman().getBirthday())
                    .setCountryId(awakener.getHuman().getCountry().getId_country())
                    .setExperience(awakener.getExperience())
                    .setId_guild(awakener.getGuild().getId());
        }
        else return null;
    }



    @GetMapping(value = "/getAwakenersInfo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AwakenerD> getAwakenerList(@PathVariable(value = "id") Long countryId){
        System.out.println(countryId);
        List <Awakener> awakeners = awakenerService.getAwakenersByCountry(countryId);
        List <AwakenerD> response = new ArrayList<>();
        for (Awakener awakener : awakeners) {
            response.add(new AwakenerD()
                    .setFirstName(awakener.getHuman().getFirstName())
                    .setLastName(awakener.getHuman().getLastName())
                    .setRank(awakener.getRank())
                    .setAwakeTime(awakener.getAwakeTime())
                    .setBirthday(awakener.getHuman().getBirthday())
                    .setCountryId(awakener.getHuman().getCountry().getId_country())
                    .setExperience(awakener.getExperience())
                    .setId_guild(awakener.getGuild().getId()));
        }
        System.out.println(response.size());

        return response;
    }

    @PostMapping(value = "/createGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> createGroup(@RequestBody GroupD groupD){
        responseMap = new HashMap<>();
        System.out.println(groupD);

        coordinatorService.addGroup(groupD.getAccessLevel());
        responseMap.put("result", "true");
        return responseMap;
    }


    @PostMapping(value = "/addAwakenerToGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addAwakenerToGroup(@RequestBody AwakenerInGroupD awakenerInGroupD){
        responseMap = new HashMap<>();
        coordinatorService.addAwakenerToGroup(awakenerInGroupD.getHuman_id(), awakenerInGroupD.getGroup_id(), new Timestamp(System.currentTimeMillis()));
        responseMap.put("result", "true");
        return responseMap;
    }

    @PostMapping(value = "/removeAwakenerFromGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> removeAwakenerFromGroup(@RequestBody AwakenerInGroupD awakenerInGroupD){
        responseMap = new HashMap<>();
        try {
            coordinatorService.removeAwakenerFromGroup(awakenerInGroupD.getHuman_id(), awakenerInGroupD.getGroup_id());
            responseMap.put("result", "true");
            return responseMap;
        }catch (Exception e){
            responseMap.put("result", "false");
            return responseMap;
        }
    }

    @PostMapping(value = "/addArtifactOrMonsterType", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addArtifactOrMonsterType(@RequestBody TypesD typesD){
        responseMap = new HashMap<>();
        registerService.setArtifactOrMonsterType(typesD.getName(), typesD.getDescription(), typesD.getClassTypeName());
        responseMap.put("result", "true");
        return responseMap;
    }

    @PostMapping(value = "/addArtifact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addArtifact(@RequestBody ArtifactD artifactD){
        responseMap = new HashMap<>();
        System.out.println(artifactD.toString());
        registerService.addArtifact(artifactD.getId_type(), artifactD.getId_rift(), artifactD.getPrice());
        responseMap.put("result", "true");
        return responseMap;
    }

    @PostMapping(value = "/addMonster", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addMonster(@RequestBody MonsterD monsterD){
        responseMap = new HashMap<>();
        registerService.addMonster(monsterD.getId_type(), monsterD.getId_rift(), monsterD.getRank());
        responseMap.put("result", "true");
        return responseMap;
    }

    @PostMapping(value = "/addRift", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addRift(@RequestBody RiftD riftD){
        responseMap = new HashMap<>();
        System.out.println();
        System.out.println();
        System.out.println(riftD.toString());
        System.out.println();
        System.out.println();
        registerService.addRift(riftD.getCoordinateId(), riftD.getCountryId(), riftD.getRank(), riftD.getAccessLevel(),
                riftD.getReward());
        responseMap.put("result", "true");
        return responseMap;
    }

    @PostMapping(value = "/addRc", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addRc(@RequestBody RecyclingCenterD recyclingCenterD){
        responseMap = new HashMap<>();
        System.out.println();
        System.out.println(recyclingCenterD);
        System.out.println();
        rcManagerService.addRc(recyclingCenterD.getCoordinateId(), recyclingCenterD.getTypeId(), recyclingCenterD.getCountryId(),
                recyclingCenterD.getAccess_level());
        responseMap.put("result", "true");
        return responseMap;
    }


    @DeleteMapping(value = "/deleteRc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> deleteRc(@PathVariable(value = "id") Long rcId) {
        responseMap = new HashMap<>();
        try {
            rcManagerService.deleteRc(rcId);
            responseMap.put("result", "true");
            return responseMap;
        } catch (Exception e){
            responseMap.put("result", "false");
            return responseMap;
        }
    }

    @GetMapping(value = "/getRcInfo/{id_country}/{access_level}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecyclingCenterR> getAwakenerList(@PathVariable(value = "id_country") Long countryId,
                                                  @PathVariable(value = "access_level") Integer access_level){
        return rcManagerService.getRcList(countryId, access_level);
    }



















}
