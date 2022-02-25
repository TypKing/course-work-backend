package com.example.courseworkbackend.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class BusinessPairKey implements Serializable{
    @ManyToOne
    @MapsId
    private Rift id_rift;

    @ManyToOne
    @MapsId
    private RecyclingCenter id_center;
}
