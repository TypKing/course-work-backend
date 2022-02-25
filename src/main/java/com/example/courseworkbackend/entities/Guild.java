package com.example.courseworkbackend.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Guilds")
public class Guild {

    @Id
    @Column(name = "id_country")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_country")
    private Country country;
    private String name;

}
