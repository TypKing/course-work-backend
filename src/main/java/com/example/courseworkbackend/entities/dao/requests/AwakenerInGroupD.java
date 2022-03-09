package com.example.courseworkbackend.entities.dao.requests;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class AwakenerInGroupD {

    private Long human_id;
    private Long group_id;
}
