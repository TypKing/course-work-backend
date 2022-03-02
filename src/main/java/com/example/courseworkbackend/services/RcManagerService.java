package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Country;
import com.example.courseworkbackend.entities.RecyclingCenter;
import com.example.courseworkbackend.repositories.RecyclingCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RcManagerService {

    private RecyclingCenterRepository recyclingCenterRepository;

    public List<RecyclingCenter> getRcList(Country country, Integer access) {
        return recyclingCenterRepository.getRecyclingCenterByCountry(country.getId_country(), access);
    }

    public void addRc(RecyclingCenter recyclingCenter){
        recyclingCenterRepository.save(recyclingCenter);
    }

    public void deleteRc(Long id){
        recyclingCenterRepository.deleteById(id);
    }

}
