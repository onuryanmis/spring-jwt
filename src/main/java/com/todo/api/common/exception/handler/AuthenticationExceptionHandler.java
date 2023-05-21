package com.todo.api.common.exception.handler;

import com.todo.api.common.exception.definition.ErrorCode;
import com.todo.api.common.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AuthenticationExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(AuthenticationException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code(ErrorCode.AUTHENTICATION_FAILURE)
                .timestamp(LocalDateTime.now())
                .messages(new String[]{"Geçersiz kullanıcı adı veya şifre"})
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
