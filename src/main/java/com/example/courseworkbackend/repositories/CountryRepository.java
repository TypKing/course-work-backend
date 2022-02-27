package com.example.courseworkbackend.repositories;

import com.example.courseworkbackend.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
