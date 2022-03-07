package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Awakeners")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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
