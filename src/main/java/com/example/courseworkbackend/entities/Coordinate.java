package com.example.courseworkbackend.entities;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "coordinates")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coordinate;
    private Float latitude;
    private Float longitude;

}
