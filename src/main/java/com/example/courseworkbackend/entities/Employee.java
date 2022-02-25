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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Human human;

    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;

    private Integer experience;
    private Integer accessLevel;
    private Timestamp startTime;
    private Timestamp endTime;
}
