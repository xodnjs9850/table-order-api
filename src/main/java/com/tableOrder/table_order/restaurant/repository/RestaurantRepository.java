package com.tableOrder.table_order.restaurant.repository;

import com.tableOrder.table_order.restaurant.entity.RestaurantEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {

    @Transactional
    @Modifying
    @Query("INSERT INTO RestaurantEntity (name, userID) VALUES (:name, :userID)")
    void insertRestaurant(@Param("name") String name, @Param("userID") String userID);

    RestaurantEntity findByNameAndUserID(String name, String userID);

    RestaurantEntity findByName(String name);
}
