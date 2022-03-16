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
@Table(name = "Types")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type;

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String description;
    @Enumerated(EnumType.STRING)
    @NotNull
    private ClassType class_type;

}
