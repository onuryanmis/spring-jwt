package com.todo.api.common.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse<T> {

    private int status;

    private String message;

    private T data;
}
