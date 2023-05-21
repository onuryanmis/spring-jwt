package com.todo.api.auth.controller;

import com.todo.api.auth.request.LoginRequest;
import com.todo.api.auth.request.RegisterRequest;
import com.todo.api.auth.response.AuthResponse;
import com.todo.api.auth.service.AuthService;
import com.todo.api.common.exception.response.SuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<SuccessResponse<AuthResponse>> register(
            @Valid @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<SuccessResponse<AuthResponse>> authenticate(
            @Valid @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }
}