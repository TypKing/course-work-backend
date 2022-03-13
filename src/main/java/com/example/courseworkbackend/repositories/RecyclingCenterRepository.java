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

    List<RecyclingCenter> getRecyclingCenterByCountry(Country country);

    @Query(value = "select * from array_center_access(cast(? as bigint))", nativeQuery = true)
    List<RecyclingCenter> getListRCByIdEmployeeAccessLevel(Long employeeId);
}
