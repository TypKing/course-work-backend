package com.example.courseworkbackend.entities.dao.responses;

import com.example.courseworkbackend.entities.Guild;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class AwakenerR {

    /*
    Human
     */
    private String firstName;
    private String lastName;
    private Timestamp birthday;
    private Long countryId;

    /*
    Awakener
     */

    private Long id_guild;
    private Integer rank;
    private Integer experience;
    private Timestamp awakeTime;

}
