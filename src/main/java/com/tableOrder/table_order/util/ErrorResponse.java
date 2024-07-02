package com.tableOrder.table_order.util;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorResponse {

    @NonNull
    private transient HttpStatus status;

    private String code;
    private String message;

    public static ErrorResponse of(final ErrorCode code) {
        return ErrorResponse.builder()
                .status(code.getStatus())
                .code(code.getCode())
                .message(code.getMessage())
                .build();
    }

    public static ErrorResponse of(final ErrorCode code, final String message) {
        return ErrorResponse.builder()
                .status(code.getStatus())
                .code(code.getCode())
                .message(message)
                .build();
    }

    public @NonNull HttpStatus getStatus() {
        return status;
    }

    @Builder
    public ErrorResponse(@NonNull HttpStatus status, String code, String message) {
        this.status = status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status;
        this.code = code;
        this.message = message;
    }

}
