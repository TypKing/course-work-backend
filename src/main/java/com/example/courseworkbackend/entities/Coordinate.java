package com.example.courseworkbackend.entities;


import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    @NotNull
    @Min(-90)
    @Max(90)
    private Float latitude;
    @NotNull
    @Min(-180)
    @Max(180)
    private Float longitude;

}
