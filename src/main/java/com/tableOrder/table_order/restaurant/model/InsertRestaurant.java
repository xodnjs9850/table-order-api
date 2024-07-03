package com.tableOrder.table_order.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class InsertRestaurant {

    private String restaurantName;

    private ArrayList<String> menuList;

}
