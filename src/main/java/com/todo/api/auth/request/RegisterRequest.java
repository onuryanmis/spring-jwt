package com.todo.api.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Ad alanı boş olamaz!")
    @Size(max = 40, message = "Ad alanı 40 karakterden uzun olamaz!")
    private String firstname;

    @NotBlank(message = "Soyad alanı boş olamaz!")
    @Size(max = 40, message = "Soyad alanı 40 karakterden uzun olamaz!")
    private String lastname;

    @NotBlank(message = "E-posta alanı boş olamaz!")
    @Size(max = 100, message = "E-posta alanı 100 karakterden uzun olamaz!")
    @Email(message = "E-posta alanı geçerli bir e-posta adresi olmalıdır!")
    private String email;

    @NotBlank(message = "Şifre alanı boş olamaz!")
    @Size(min = 6, message = "Şifre alanı en az 6 karakterden oluşmalıdır!")
    private String password;
}
