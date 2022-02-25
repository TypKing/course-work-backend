package com.example.courseworkbackend.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usr")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String role;


}
