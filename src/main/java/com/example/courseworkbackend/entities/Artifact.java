package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "Artifacts")
@NoArgsConstructor
@AllArgsConstructor
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_artifact;

    @ManyToOne
    @MapsId
    private Types type;

    @ManyToOne
    @MapsId
    private Rift rift;

    private Integer price;

}
