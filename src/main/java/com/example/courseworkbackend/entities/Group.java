package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

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
    private Integer accessLevel;

}
