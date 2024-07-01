package com.tableOrder.table_order.util.exception;

import com.tableOrder.table_order.util.ErrorCode;

public class BadCredentialsException extends CustomException {
    public BadCredentialsException(String target) {
        super("인증 실패 : " + target, ErrorCode.HANDLE_ACCESS_DENIED);
    }
}
