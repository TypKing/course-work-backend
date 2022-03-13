package com.example.courseworkbackend.entities.dao.responses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MonsterR {

    private Long monsterId;
    private int rank;
    private String typeName;
}
