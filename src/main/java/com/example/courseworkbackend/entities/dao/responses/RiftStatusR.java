package com.example.courseworkbackend.entities.dao.responses;

import com.example.courseworkbackend.entities.Group;
import com.example.courseworkbackend.entities.Rift;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class RiftStatusR {

    private Long id;
    private String groupName;

    private boolean RiftCondition;
    private Timestamp time;
    private Timestamp openTime;
    private boolean result;

}
