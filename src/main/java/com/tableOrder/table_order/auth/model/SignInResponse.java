package com.tableOrder.table_order.auth.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SignInResponse {
    private String accessToken;
    private String refreshToken;
}
