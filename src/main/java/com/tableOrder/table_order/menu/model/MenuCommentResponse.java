package com.tableOrder.table_order.menu.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MenuCommentResponse {
    private String menuName;
    private String comment;
    private int price;
}
