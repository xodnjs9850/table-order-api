package com.tableOrder.table_order.util.exception;

import com.tableOrder.table_order.util.ErrorCode;

public class InvalidArgumentException extends CustomException {

    public InvalidArgumentException(String message) {
        super("잘못된 매개변수 값 : " + message, ErrorCode.INVALID_INPUT_VALUE);
    }
}
