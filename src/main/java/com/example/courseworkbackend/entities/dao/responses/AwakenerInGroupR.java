package com.example.courseworkbackend.entities.dao.responses;


import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class AwakenerInGroupR {

    private Long humanId;
    private Long groupId;
    private Timestamp joinTime;
    private Timestamp endTime;

}
