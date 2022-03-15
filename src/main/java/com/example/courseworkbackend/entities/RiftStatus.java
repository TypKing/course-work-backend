package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Rifts_status")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RiftStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rift id_rift;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group_id;

    private boolean Rift_condition;
    private Timestamp time;
    private Timestamp time_to_open;
    private boolean result;

}
