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
@Table(name = "Humans")
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_human;
    private String firstName;
    private String lastName;
    private Timestamp birthday;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country countryId;

}
