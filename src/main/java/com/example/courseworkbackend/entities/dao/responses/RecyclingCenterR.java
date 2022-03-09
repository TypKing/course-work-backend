package com.example.courseworkbackend.entities.dao.responses;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RecyclingCenterR {

    private String coordinateName;
    private String typeName;
    private String countryName;
    private Integer access_level;

}