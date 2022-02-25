package com.example.courseworkbackend.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "coordinates")
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coordinate;
    private Float latitude;
    private Float longitude;

}
