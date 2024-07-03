package com.tableOrder.table_order.restaurant.service;

import com.tableOrder.table_order.menu.entity.MenuEntity;
import com.tableOrder.table_order.menu.repository.MenuRepository;
import com.tableOrder.table_order.restaurant.entity.RestaurantEntity;
import com.tableOrder.table_order.restaurant.repository.RestaurantRepository;
import com.tableOrder.table_order.util.exception.InvalidArgumentException;
import com.tableOrder.table_order.util.exception.ValueAlreadyException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    static Logger logger = LoggerFactory.getLogger(RestaurantService.class);

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;


    public void insertRestaurant(String userEmail, String restaurantName, ArrayList<String> menus) {

        if (restaurantName.isBlank() && userEmail.isBlank()) {
            throw new InvalidArgumentException("레스토랑 이름을 입력해주세요.");
        }

        if (restaurantRepository.findByNameAndUserID(restaurantName, userEmail) != null) {
            throw new ValueAlreadyException("레스토랑이 이미 존재합니다.");
        }

        restaurantRepository.insertRestaurant(restaurantName, userEmail);
        RestaurantEntity restaurant = restaurantRepository.findByNameAndUserID(restaurantName, userEmail);

        for (String menu : menus) {
            String[] menuAndPrice = menu.split("-");
            MenuEntity newMenu = MenuEntity.builder()
                    .name(menuAndPrice[0])
                    .price(Integer.valueOf(menuAndPrice[1]))
                    .restaurant(restaurant)
                    .build();
            menuRepository.save(newMenu);
        }
    }

}
