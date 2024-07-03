package com.tableOrder.table_order.order.repository;

import com.tableOrder.table_order.order.entity.OrderEntity;
import com.tableOrder.table_order.restaurant.entity.RestaurantEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.basket = :basket WHERE o.email = :email AND o.restaurant = :restaurantId")
    void updateOrders(@Param("basket") String basket, @Param("email") String email, @Param("restaurantId") RestaurantEntity restaurantId);

}
