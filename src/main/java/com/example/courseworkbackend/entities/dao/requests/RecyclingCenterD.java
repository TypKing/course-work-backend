package com.example.courseworkbackend.entities.dao.requests;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RecyclingCenterD {

    private Long coordinateId;
    private Long typeId;
    private Long countryId;
    private Integer access_level;

}
