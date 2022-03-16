package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;

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
    @NotNull
    private String name;
    @NotNull
    @Min(0)
    private Integer area;
    @NotNull
    @Min(0)
    private Integer population;
    @NotNull
    @Min(0)
    private Integer money_reserve;

}
