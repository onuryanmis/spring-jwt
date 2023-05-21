package com.todo.api.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "E-posta alanı boş olamaz!")
    @Email(message = "E-posta alanı geçerli bir e-posta adresi olmalıdır!")
    private String email;

    @NotBlank(message = "Şifre alanı boş olamaz!")
    private String password;
}
