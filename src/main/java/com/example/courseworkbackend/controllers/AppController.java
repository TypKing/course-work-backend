package com.example.courseworkbackend.controllers;

import com.example.courseworkbackend.entities.Awakener;
import com.example.courseworkbackend.entities.dao.requests.AwakenerD;
import com.example.courseworkbackend.services.AwakenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    @Autowired
    private AwakenerService awakenerService;

    private HashMap<String, String> responseMap;

    @PostMapping(value = "/addAwakener", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> userAuth(@RequestBody AwakenerD awakenerD){
        responseMap = new HashMap<>();
        boolean result = false;

        System.out.println("Добавление проходит пробужденный: " + awakenerD.getFirstName());
        if (awakenerService.addAwakener(awakenerD.getFirstName(), awakenerD.getFirstName(), awakenerD.getBirthday(),
                awakenerD.getCountryId(), awakenerD.getId_guild(), awakenerD.getRank(), awakenerD.getExperience(),
                awakenerD.getAwakeTime())){
            result = true;
        }
        responseMap.put("result", Boolean.toString(result));
        return responseMap;
    }

    @DeleteMapping(value = "/deleteAwakener/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> userAuth(@PathVariable(value = "id") Long awakenerId {
        responseMap = new HashMap<>();
        awakenerService.deleteAwakener(awakenerId);
        responseMap.put("result", "true");
        return responseMap;
    }

    @GetMapping(value = "/getAwakenerInfo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
}
