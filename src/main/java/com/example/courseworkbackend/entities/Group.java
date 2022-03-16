package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Groups")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_group;
    @NotNull
    @NotEmpty
    private String name;
    @Min(0)
    @Max(7)
    private Integer accessLevel;

}
