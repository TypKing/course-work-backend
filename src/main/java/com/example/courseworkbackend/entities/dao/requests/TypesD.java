package com.example.courseworkbackend.entities.dao.requests;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TypesD {

    private String name;
    private String description;
    private String classTypeName;

}
