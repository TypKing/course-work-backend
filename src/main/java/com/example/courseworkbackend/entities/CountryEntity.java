package com.example.courseworkbackend.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "Countries")
public class CountryEntity {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id_country;
    private String name;
    private Integer area;
    private Integer population;
    private Integer money_reserve;

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id_country=" + id_country +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", population=" + population +
                ", money_reserve=" + money_reserve +
                '}';
    }
}
