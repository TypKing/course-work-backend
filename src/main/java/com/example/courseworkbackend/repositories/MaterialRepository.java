package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Material;
import com.example.courseworkbackend.entities.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Query(value = "select * from list_materials(cast(? as bigint))", nativeQuery = true)
    public List<Material> getListMaterials(Long riftId);
}
