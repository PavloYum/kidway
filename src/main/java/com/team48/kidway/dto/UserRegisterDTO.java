package com.team48.kidway.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private String tel;
}