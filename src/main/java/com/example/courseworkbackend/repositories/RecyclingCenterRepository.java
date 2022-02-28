package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Country;
import com.example.courseworkbackend.entities.RecyclingCenter;
import com.example.courseworkbackend.entities.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecyclingCenterRepository extends JpaRepository<RecyclingCenter, Long> {
    @Modifying
    //@Query("select rc from RecyclingCenter rc, BusinessPair bp, Rift ri where rc.id = bp.businessPairKey.id_center and bp.businessPairKey.id_rift = ri.id and ri.country = :counry")
    List<RecyclingCenter> getRecyclingCenterByCountry(@Param(value = "country")Country country);
}
