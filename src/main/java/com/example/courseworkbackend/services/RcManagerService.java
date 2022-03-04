package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Country;
import com.example.courseworkbackend.entities.RecyclingCenter;
import com.example.courseworkbackend.repositories.CoordinateRepository;
import com.example.courseworkbackend.repositories.CountryRepository;
import com.example.courseworkbackend.repositories.RecyclingCenterRepository;
import com.example.courseworkbackend.repositories.TypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RcManagerService {

    private RecyclingCenterRepository recyclingCenterRepository;
    private CountryRepository countryRepository;
    private CoordinateRepository coordinateRepository;
    private TypesRepository typesRepository;

//    public List<RecyclingCenter> getRcList(Long id_country, Integer access) {
//        return recyclingCenterRepository.getRecyclingCenterById(id_country, access);
//    }

    public void addRc(Long id_coordinate, Long id_type, Long id_country, Integer accessLevel){
        recyclingCenterRepository.save(
                new RecyclingCenter()
                        .setCoordinate(coordinateRepository.getById(id_coordinate))
                        .setType(typesRepository.getById(id_type))
                        .setCountry(countryRepository.getById(id_country))
                        .setAccess_level(accessLevel)
                    );
    }

    public void deleteRc(Long id){
        recyclingCenterRepository.deleteById(id);
    }

}
