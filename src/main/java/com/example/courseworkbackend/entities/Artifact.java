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
@Accessors(chain = true)
@Table(name = "Artifacts")
@NoArgsConstructor
@AllArgsConstructor
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_artifact;

    @ManyToOne
    @NotNull
    private Types type;

    @ManyToOne
    @NotNull
    private Rift rift;

    @NotNull
    @Min(0)
    private Integer price;

}
