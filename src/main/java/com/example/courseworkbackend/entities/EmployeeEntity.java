package com.example.courseworkbackend.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @MapsId
    private HumanEntity human;

    @ManyToOne
    @MapsId
    private PositionEntity position;

    private Integer experience;

    @Column(name = "access_level")
    private Integer accessLevel;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;
}
