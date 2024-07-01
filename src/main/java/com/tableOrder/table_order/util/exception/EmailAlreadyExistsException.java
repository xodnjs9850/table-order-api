package com.tableOrder.table_order.util.exception;

import com.tableOrder.table_order.util.ErrorCode;

public class EmailAlreadyExistsException extends CustomException {
    public EmailAlreadyExistsException(String message) {
        super("존재하는 이메일입니다.", ErrorCode.EMAIL_DUPLICATION);
    }
}
