package com.springbootcourse.http.dto.response.role;

import com.springbootcourse.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleResponse {

    private UUID roleId;

    private RoleEnum roleName;
}
