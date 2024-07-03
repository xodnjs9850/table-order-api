package com.tableOrder.table_order.menu.service;

import com.tableOrder.table_order.menu.entity.InformationEntity;
import com.tableOrder.table_order.menu.entity.MenuEntity;
import com.tableOrder.table_order.menu.repository.InformationRepository;
import com.tableOrder.table_order.menu.repository.MenuRepository;
import com.tableOrder.table_order.restaurant.entity.RestaurantEntity;
import com.tableOrder.table_order.restaurant.repository.RestaurantRepository;
import com.tableOrder.table_order.util.exception.ValueAlreadyException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MenuService {

    static Logger logger = LoggerFactory.getLogger(MenuService.class);
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final InformationRepository informationRepository;

    public List<MenuEntity> findByRestaurantMenus(String restaurantName) {

        if (restaurantName.isBlank()) {
            throw new ValueAlreadyException("필수 파라미터가 누락되었습니다.");
        }

        RestaurantEntity restaurant = restaurantRepository.findByName(restaurantName);
        return menuRepository.findByRestaurantId(restaurant.getId());
    }

    public void insertComment(String menuName, String restaurantName, String comment) {

        if (menuName.isBlank() || restaurantName.isBlank() || comment.isBlank()) {
            throw new ValueAlreadyException("필수 파라미터가 누락되었습니다.");
        }

        RestaurantEntity restaurant = restaurantRepository.findByName(restaurantName);
        MenuEntity menu = menuRepository.findByRestaurantIdAndName(restaurant.getId(), menuName);
        InformationEntity information = informationRepository.findByMenuId(menu.getId());

        if (information == null) {

            InformationEntity newInformation = InformationEntity.builder()
                    .comment(comment)
                    .menu(menu)
                    .build();

            informationRepository.save(newInformation);

        }
    }


    public InformationEntity findByMenuComment(String menuName, String restaurantName) {

        if (menuName.isBlank() || restaurantName.isBlank()) {
            throw new ValueAlreadyException("필수 파라미터가 누락되었습니다.");
        }

        RestaurantEntity restaurant = restaurantRepository.findByName(restaurantName);
        MenuEntity menu = menuRepository.findByRestaurantIdAndName(restaurant.getId(), menuName);
        return informationRepository.findByMenuId(menu.getId());
    }


}
