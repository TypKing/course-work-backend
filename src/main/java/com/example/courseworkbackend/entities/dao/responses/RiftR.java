package com.example.courseworkbackend.entities.dao.responses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RiftR {

    private Long id;
    private String coordinateX;
    private String coordinateY;
    private String countryName;
    private Integer reward;
    private Integer rank;
    private Integer accessLevel;

}
