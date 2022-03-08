package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Awakener;
import com.example.courseworkbackend.entities.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwakenerRepository extends JpaRepository<Awakener, Long> {
    //SELECT * FROM Employee e, Team t WHERE e.Id_team=t.Id_team
    @Modifying
    @Query("from Awakener a, Human h where a.human=h and h.country.id_country =: id")
    List<Awakener> findAllByContryId(@Param(value = "id") long id);
}
