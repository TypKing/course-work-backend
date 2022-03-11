package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Country;
import com.example.courseworkbackend.entities.dao.responses.CitiesR;
import com.example.courseworkbackend.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComponentLoaderService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CitiesR> getCountriesMap(){
        List <Country> list = countryRepository.findAll();
        List <CitiesR> listN = new ArrayList<>();
        if (!list.isEmpty()){
            for (Country country : list) {
                listN.add(new CitiesR().setName(country.getName()).setId(country.getId_country()));
            }
        }
        return listN;
    }

}
