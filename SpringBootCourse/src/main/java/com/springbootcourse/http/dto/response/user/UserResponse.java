package com.springbootcourse.http.dto.response.user;

import com.springbootcourse.http.dto.response.role.RoleResponse;
import com.springbootcourse.model.RoleModel;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private UUID userId;

    private String name;

    private String email;

    private String telephone;

    private Integer age;

    private String password;

    private List<RoleResponse> roles;
}
