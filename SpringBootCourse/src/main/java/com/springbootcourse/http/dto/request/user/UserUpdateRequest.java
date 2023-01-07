package com.springbootcourse.http.dto.request.user;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserUpdateRequest {

    private UUID userId;

    private String name;

    private String email;

    private String telephone;

    private Integer age;

    private String password;

    private List<UUID> roleIds;
}
