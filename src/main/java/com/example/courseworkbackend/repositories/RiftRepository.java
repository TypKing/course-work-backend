package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Monster;
import com.example.courseworkbackend.entities.Rift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiftRepository extends JpaRepository<Rift, Long> {
    @Query(value = "select * from array_rift_access(cast(? as bigint))", nativeQuery = true)
    List<Rift> getListRiftByIdEmployeeAccessLevel(Long employeeId);
}
