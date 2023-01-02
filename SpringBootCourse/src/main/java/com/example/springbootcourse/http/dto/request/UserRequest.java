package com.example.springbootcourse.http.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private String name;

    private String email;

    private String telephone;

    private Integer age;

    private String password;
}
