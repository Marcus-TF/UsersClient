package com.springbootcourse.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class UserInsertRequest {

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
