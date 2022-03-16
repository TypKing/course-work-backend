package com.example.courseworkbackend.entities;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Guilds")
@NoArgsConstructor
@AllArgsConstructor
public class Guild {

    @Id
    @Column(name = "id_country")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_country")
    private Country country;
    @NotNull
    private String name;

}
