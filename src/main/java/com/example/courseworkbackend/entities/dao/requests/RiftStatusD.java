package com.example.courseworkbackend.entities.dao.requests;

import com.example.courseworkbackend.entities.Group;
import com.example.courseworkbackend.entities.Rift;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class RiftStatusD {

    private Long riftId;
    private Long groupId;
    private boolean firstCondition;
    private Timestamp openTime;
    private boolean result;
}
