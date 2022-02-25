package com.example.courseworkbackend.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Types")
@NoArgsConstructor
@AllArgsConstructor
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ClassType class_type;



}
