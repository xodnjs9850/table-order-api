package com.tableOrder.table_order.util.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

@Getter
public enum ErrorCode {

    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "INVALID_INPUT_VALUE", "잘못된 요청입니다."),
    ;

    private final String code;
    private final String message;
    @NonNull
    private final HttpStatus status;


    ErrorCode(final HttpStatus status, final String code, final String message) {
        this.status = status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status;
        this.message = message;
        this.code = code;
    }
}
