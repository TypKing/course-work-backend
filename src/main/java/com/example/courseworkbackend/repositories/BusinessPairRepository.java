package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.BusinessPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessPairRepository extends JpaRepository<BusinessPair, Long> {

}
