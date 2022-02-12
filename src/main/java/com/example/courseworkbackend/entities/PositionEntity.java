package com.example.courseworkbackend.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@Accessors(chain = true)
@Table(name = "Positions")
public class PositionEntity {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "id", updatable=false)
    private Integer id;
    private String position_name;
    private Integer salary;

    @Override
    public String toString() {
        return "PositionEntity{" +
                "id=" + id +
                ", position_name='" + position_name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
