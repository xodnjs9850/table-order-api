package com.tableOrder.table_order.auth.model;

import lombok.Getter;

@Getter
public class SignUpRequest {
    private String email;
    private String password;
    private String name;
}
