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
@Table(name = "Awakeners")
public class AwakenerEntity {

    @Id
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id")
    private HumanEntity id;

    private Integer rank;

    private Integer experience;

    @Column(name = "awake_guild")
    @ManyToOne
    @MapsId
    private GuildEntity guild;

    @Column(name = "awake_time")
    private Timestamp awakeTime;


}
