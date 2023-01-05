package com.springbootcourse.http.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserUpdateRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Email(message = "Informe um email válido.")
    private String email;

    @NotBlank
    @Size(max = 14)
    private String telephone;

    @NotNull
    private Integer age;

    @NotBlank
    @Length(min = 8, max = 16, message = "Informe uma senha entre 8 a 16 dígitos.")
    private String password;
}
