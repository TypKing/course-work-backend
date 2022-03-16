package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Employees")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Human human;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Position positionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Guild guild;

    @NotNull
    @Min(0)
    private Integer experience;
    @NotNull
    @Min(0)
    @Max(7)
    private Integer accessLevel;
    @NotNull
    private Timestamp startTime;
    private Timestamp endTime;
}
