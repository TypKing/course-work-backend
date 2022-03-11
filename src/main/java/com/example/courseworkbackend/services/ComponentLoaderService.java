package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Country;
import com.example.courseworkbackend.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComponentLoaderService {

    @Autowired
    private CountryRepository countryRepository;

    public Map<Long, String> getCountriesMap(){
        Map<Long, String> map = new HashMap<>();
        List <Country> list = countryRepository.findAll();
        for (Country country : list) {
            map.put(country.getId_country(), country.getName());
        }
        return map;
    }

}
