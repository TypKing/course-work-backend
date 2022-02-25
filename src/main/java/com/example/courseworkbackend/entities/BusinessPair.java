package com.example.courseworkbackend.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Business_pairs")
@NoArgsConstructor
@AllArgsConstructor
public class BusinessPair {
    @EmbeddedId
    private BusinessPairKey businessPairKey;
}
