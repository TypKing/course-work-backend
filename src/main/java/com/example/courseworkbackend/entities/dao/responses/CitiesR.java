package com.example.courseworkbackend.entities.dao.responses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CitiesR {

    private String name;
    private Long id;

}
