package com.example.courseworkbackend.entities;


import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@ToString
@Table(name = "AwakenersInGroup")
@NoArgsConstructor
@AllArgsConstructor
public class AwakenerInGroup {

    @EmbeddedId
    private AwakenerInGroupKey awakenerInGroupKey;
    private Timestamp joinTime;
    private Timestamp endTime;

}
