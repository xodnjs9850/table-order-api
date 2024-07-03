package com.tableOrder.table_order.menu.repository;

import com.tableOrder.table_order.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    List<MenuEntity> findByRestaurantId(Integer restaurantId);

    MenuEntity findByRestaurantIdAndName(Integer restaurantId, String name);

}
