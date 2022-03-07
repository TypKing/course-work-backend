package com.example.courseworkbackend.entities.dao.responses;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginResponse {
    private boolean flag;
    private String role;
}
