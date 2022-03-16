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
@Accessors(chain = true)
@Table(name = "Monsters")
@NoArgsConstructor
@AllArgsConstructor
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_monster;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Types types;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Rift detection_rift;

    @NotNull
    @Min(0)
    @Max(7)
    private Integer rank;

}
