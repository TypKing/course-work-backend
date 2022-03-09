package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    private Integer rank;
    private Integer accessLevel;
    private Integer reward;

}
