package com.example.courseworkbackend.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Countries")
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_country;
    private String name;
    private Integer area;
    private Integer population;
    private Integer money_reserve;

}
