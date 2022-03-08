package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "usr")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    @Id
    @Column(name = "id_employee")
    private Long id_user;

    private String login;
    private String password;

    @OneToOne(orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id_employee")
    private Employee employee;

}
