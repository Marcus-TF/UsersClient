package com.springbootcourse.http.dto.response.user;

import com.springbootcourse.http.dto.response.role.RoleResponse;
import com.springbootcourse.model.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInsertResponse {

    private UUID userId;

    private String name;

    private String email;

    private String telephone;

    private Integer age;

    private String password;

    private List<RoleResponse> roles;
}
