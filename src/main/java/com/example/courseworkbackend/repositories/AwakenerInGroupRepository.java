package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Awakener;
import com.example.courseworkbackend.entities.AwakenerInGroup;
import com.example.courseworkbackend.entities.AwakenerInGroupKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwakenerInGroupRepository extends JpaRepository<AwakenerInGroup, AwakenerInGroupKey> {
}
