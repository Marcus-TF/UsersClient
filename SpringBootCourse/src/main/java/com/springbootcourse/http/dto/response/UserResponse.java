package com.springbootcourse.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

    private UUID userId;

    private String name;

    private String email;

    private String telephone;

    private Integer age;

    private String password;
}
