package com.todo.api.common.exception.response;

import com.todo.api.common.exception.definition.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private int status;

    private ErrorCode code;

    private String[] messages;

    private LocalDateTime timestamp;
}
