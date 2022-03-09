package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "Materials")
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_material;

    @ManyToOne
    @MapsId
    private Monster monster_drop;

    private String name;
    private Integer price;

}
