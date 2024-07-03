package com.tableOrder.table_order.order.entity;

import com.tableOrder.table_order.menu.entity.MenuEntity;
import com.tableOrder.table_order.restaurant.entity.RestaurantEntity;
import com.tableOrder.table_order.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String basket;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    private RestaurantEntity restaurant;

}
