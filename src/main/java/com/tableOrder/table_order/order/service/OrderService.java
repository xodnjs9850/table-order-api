package com.tableOrder.table_order.order.service;

import com.tableOrder.table_order.menu.entity.MenuEntity;
import com.tableOrder.table_order.menu.repository.MenuRepository;
import com.tableOrder.table_order.order.entity.OrderEntity;
import com.tableOrder.table_order.order.repository.OrderRepository;
import com.tableOrder.table_order.restaurant.entity.RestaurantEntity;
import com.tableOrder.table_order.restaurant.repository.RestaurantRepository;
import com.tableOrder.table_order.util.exception.InvalidArgumentException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {

    static Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    public void insertOrders(String userEmail, String restaurantName, ArrayList<String> menus) {

        if (restaurantName.isBlank() || userEmail.isBlank()) {
            throw new InvalidArgumentException("필수 파라미터가 없습니다.");
        }

        RestaurantEntity restaurant = restaurantRepository.findByName(restaurantName);

        StringBuilder menuList = new StringBuilder();
        for (String menu : menus) {
            if (menuRepository.findByRestaurantIdAndName(restaurant.getId(), menu.trim()) == null) {
                throw new InvalidArgumentException("없는 메뉴 : " + menu);
            }

            if (menus.getLast().equals(menu)) {
                menuList.append(menu);
            } else {
                menuList.append(menu).append(",");
            }
        }

        OrderEntity order = OrderEntity.builder()
                .email(userEmail)
                .basket(menuList.toString())
                .restaurant(restaurant)
                .build();

        orderRepository.save(order);
    }

    public void updateOrders(String userEmail, String restaurantName, ArrayList<String> menus) {

        if (restaurantName.isBlank() || userEmail.isBlank()) {
            throw new InvalidArgumentException("필수 파라미터가 없습니다.");
        }

        RestaurantEntity restaurant = restaurantRepository.findByName(restaurantName);

        StringBuilder menuList = new StringBuilder();
        for (String menu : menus) {

            if (menuRepository.findByRestaurantIdAndName(restaurant.getId(), menu.trim()) == null) {
                throw new InvalidArgumentException("없는 메뉴 : " + menu);
            }

            if (menus.getLast().equals(menu)) {
                menuList.append(menu);
            } else {
                menuList.append(menu).append(",");
            }
        }
        orderRepository.updateOrders(menuList.toString(), userEmail, restaurant);
    }

}
