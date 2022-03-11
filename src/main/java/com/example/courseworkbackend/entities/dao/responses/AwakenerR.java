package com.example.courseworkbackend.entities.dao.responses;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class AwakenerR {

    /*
    Human
     */
    private Long id;
    private String firstName;
    private String lastName;
    private Timestamp birthday;
    private Long countryId;
    private String countryName;

    /*
    Awakener
     */

    private Long guildId;
    private Integer rank;
    private Integer experience;
    private Timestamp awakeTime;

}
