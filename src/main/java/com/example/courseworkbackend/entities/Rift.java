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
@Table(name = "Rifts")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Rift {

    @Id
    @Column(name = "id_coordinate")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_coordinate")
    private Coordinate coordinate;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Country country;
    @NotNull
    @Min(0)
    @Max(7)
    private Integer rank;
    @NotNull
    @Min(0)
    @Max(7)
    private Integer accessLevel;
    @NotNull
    @Min(0)
    private Integer reward;

}
