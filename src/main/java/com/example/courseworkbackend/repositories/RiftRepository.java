package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Monster;
import com.example.courseworkbackend.entities.Rift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiftRepository extends JpaRepository<Rift, Long> {
    @Query(value = "select * from array_group_access(cast(?1 as bigint), cast(?2 as bigint))", nativeQuery = true)
    List<Rift> getListRiftByGroupAndCountry(Long group_id, Long country_id);

    @Query(value = "select * from array_rift_access(cast(? as bigint))", nativeQuery = true)
    List<Rift> getListRiftByIdEmployeeAccessLevel(Long employeeId);
}
