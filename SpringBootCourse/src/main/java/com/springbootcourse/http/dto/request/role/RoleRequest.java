package com.springbootcourse.http.dto.request.role;

import com.springbootcourse.enums.RoleEnum;
import lombok.Data;

@Data
public class RoleRequest {
    private RoleEnum roleName;
}
