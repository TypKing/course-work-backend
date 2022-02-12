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
public class HumanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Timestamp birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId
    @Column(name = "native_country")
    private CountryEntity countryId;

}
