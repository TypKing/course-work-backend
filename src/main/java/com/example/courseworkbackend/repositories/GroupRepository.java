package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Employee;
import com.example.courseworkbackend.entities.Group;
import com.example.courseworkbackend.entities.RecyclingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query(value = "select * from list_groups(cast(? as bigint))", nativeQuery = true)
    List<Group> getListGroupByAwakener(Long awakener);

}