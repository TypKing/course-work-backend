package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
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
    private Integer id_human;
    private String firstName;
    private String lastName;
    private Timestamp birthday;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

}
