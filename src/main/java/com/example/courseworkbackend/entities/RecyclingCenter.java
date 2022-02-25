package com.example.courseworkbackend.entities;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "Recycling_centers")
@NoArgsConstructor
@AllArgsConstructor
public class RecyclingCenter {

    @Id
    @Column(name = "id_coordinate")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_coordinate")
    private Coordinate coordinate;

    @ManyToOne
    @MapsId
    private Types type;

    private Integer access_level;

}
