package com.example.courseworkbackend.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@ToString
@Table(name = "AwakenersInGroup")
public class AwakenerInGroup {

    @Id
    private Long id;

}
