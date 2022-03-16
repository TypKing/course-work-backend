package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @NotNull
    private Rift id_rift;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group_id;

    @NotNull
    private boolean Rift_condition;
    @NotNull
    private Timestamp time;
    @NotNull
    private Timestamp time_to_open;
    @NotNull
    private boolean result;

}
