package com.tableOrder.table_order.user.model;

import com.tableOrder.table_order.util.exception.InvalidArgumentException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum UserRole {

    ADMIN(4),
    MANAGER(3),
    AUTHORIZED_USER(2),
    UNAUTHORIZED_USER(1),
    ;

    private final Integer permission;

    public static UserRole fromPermission(int permission) {
        return Arrays.stream(UserRole.values())
                .filter(role -> role.getPermission() == permission)
                .findFirst()
                .orElseThrow(() -> new InvalidArgumentException("사용할 수 없는 Role" + permission));
    }

}
