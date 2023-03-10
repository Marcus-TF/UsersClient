package com.springbootcourse.model;

import com.springbootcourse.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "role", schema = "user_microservice")
public class RoleModel implements Serializable, GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Override
    public String getAuthority() {
        return this.role.toString();
    }
}
