package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Awakener;
import com.example.courseworkbackend.entities.Employee;
import com.example.courseworkbackend.entities.Guild;
import com.example.courseworkbackend.entities.Human;
import com.example.courseworkbackend.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class AwakenerService {

    private AwakenerRepository awakenerRepository;
    private HumanRepository humanRepository;
    private CountryRepository countryRepository;
    private PositionRepository positionRepository;
    private GuildRepository guildRepository;

    public void addAwakener(
            String firstName,
            String lastName,
            Timestamp birthday,
            Long id_country,
            Long id_guild,
            Integer rank,
            Integer experience,
            Timestamp awakeTime
    ){
        Human human = new Human()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthday(birthday)
                .setCountryId(countryRepository.getById(id_country));
        humanRepository.save(human);
        awakenerRepository.save(
                new Awakener()
                        .setHuman(human)
                        .setGuild(guildRepository.getById(id_guild))
                        .setRank(rank)
                        .setExperience(experience)
                        .setAwakeTime(awakeTime)
        );
    }

    public void deleteAwakener(Long id){
        //нужно ли удалять человека из БД при удалении пробужденного?
        awakenerRepository.deleteById(id);
    }

    public Awakener getInfoById(Long id){
        return awakenerRepository.getById(id);
    }

}
