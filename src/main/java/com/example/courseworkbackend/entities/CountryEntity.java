package com.example.courseworkbackend.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Countries")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_country;

    private String name;

    private Integer area;

    private Integer population;

    private Integer money_reserve;

}
