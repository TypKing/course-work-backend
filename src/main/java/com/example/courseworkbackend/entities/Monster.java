package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "Monsters")
@NoArgsConstructor
@AllArgsConstructor
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_monster;

    @ManyToOne
    @MapsId
    private Types types;

    @ManyToOne
    @MapsId
    private Rift detection_rift;

    private Integer rank;

}
