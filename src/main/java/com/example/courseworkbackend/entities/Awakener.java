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
public class Awakener {

    @Id
    @Column(name = "id_human")
    private Long id_awakener;

    @OneToOne(orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id_human")
    private Human human;

    @ManyToOne(fetch = FetchType.LAZY)
    private Guild guild;

    private Integer rank;
    private Integer experience;
    private Timestamp awakeTime;




}
