package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecyclingCenterRepository extends JpaRepository<RecyclingCenter, Long> {
//
//    @Modifying
//    @Query("select c from RecyclingCenter c where c.access_level <= : access and c.country.id_country = :id")
//    public List<RecyclingCenter> getRecyclingCenterById(@Param("id")Long id_country, @Param("access") Integer access);

    public List<RecyclingCenter> getRecyclingCenterByCountry(Country country);
}
