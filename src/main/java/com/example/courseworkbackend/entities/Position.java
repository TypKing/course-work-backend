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
@Table(name = "Positions")
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long position_id;

    @NotNull
    @NotEmpty
    private String position_name;

    @NotNull
    @Min(0)
    private Integer salary;

}
