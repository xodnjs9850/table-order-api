package com.tableOrder.table_order.util.exception;

import com.tableOrder.table_order.util.ErrorCode;

public class ValueAlreadyException extends CustomException {
    public ValueAlreadyException(String message) {
        super(message, ErrorCode.VALUE_DUPLICATION);
    }
}
