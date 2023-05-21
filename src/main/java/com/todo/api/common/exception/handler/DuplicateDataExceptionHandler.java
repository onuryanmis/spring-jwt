package com.todo.api.common.exception.handler;

import com.todo.api.common.exception.definition.ErrorCode;
import com.todo.api.common.exception.response.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class DuplicateDataExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions() {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code(ErrorCode.DUPLICATE_DATA_FAILURE)
                .timestamp(LocalDateTime.now())
                .messages(new String[]{"Bu veri daha önce kaydedilmiş."})
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
