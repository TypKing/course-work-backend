package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Countries")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_country;
    private String name;
    private Integer area;
    private Integer population;
    private Integer money_reserve;

}
