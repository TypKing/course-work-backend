package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

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
    @NotNull
    private Monster monster_drop;

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @Min(0)
    private Integer price;

}
