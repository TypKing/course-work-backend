package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Humans")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_human;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    private Timestamp birthday;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Country country;

}
