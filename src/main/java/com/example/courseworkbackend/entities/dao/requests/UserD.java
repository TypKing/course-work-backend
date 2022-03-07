package com.example.courseworkbackend.entities.dao.requests;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserD {
    private String login;
    private String password;
}
