package com.example.courseworkbackend.entities.dao.responses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CoordinateR {

    private Long id_coordinate;
    private Float latitude;
    private Float longitude;

}
