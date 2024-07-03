package com.tableOrder.table_order.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

@Getter
public enum ErrorCode {

    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "INVALID_INPUT_VALUE", "잘못된 요청입니다."),
    EMAIL_DUPLICATION(HttpStatus.BAD_REQUEST, "EMAIL_DUPLICATION", "이메일이 이미 존재합니다."),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "HANDLE_ACCESS_DENIED", "권한이 없습니다."),
    VALUE_DUPLICATION(HttpStatus.BAD_REQUEST, "VALUE_DUPLICATION", "값 이미 존재합니다."),
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
