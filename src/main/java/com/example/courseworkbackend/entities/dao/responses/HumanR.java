package com.example.courseworkbackend.entities.dao.responses;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class HumanR {

    private Long id;
    private String firstName;
    private String lastName;
    private Timestamp birthday;
    private String countryName;

}
