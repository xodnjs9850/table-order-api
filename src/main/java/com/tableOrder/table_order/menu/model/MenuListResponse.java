package com.tableOrder.table_order.menu.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MenuListResponse {
    private String restaurantName;
    private String menuName;
    private int price;
}
