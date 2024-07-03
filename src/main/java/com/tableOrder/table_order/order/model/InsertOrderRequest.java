package com.tableOrder.table_order.order.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class InsertOrderRequest {

    private String restaurant;
    private ArrayList<String> menus;

}
