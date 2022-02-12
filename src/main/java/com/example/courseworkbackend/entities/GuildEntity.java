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
public class GuildEntity {

    @Id
    @OneToOne
    @PrimaryKeyJoinColumn
    private CountryEntity id;

    private String name;

}
