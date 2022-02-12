package com.example.courseworkbackend.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@Accessors(chain = true)
@Table(name = "Positions")
@ToString
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Integer id;

    private String position_name;

    private Integer salary;

}
