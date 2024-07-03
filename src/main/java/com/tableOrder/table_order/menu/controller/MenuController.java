package com.tableOrder.table_order.menu.controller;

import com.tableOrder.table_order.menu.entity.InformationEntity;
import com.tableOrder.table_order.menu.entity.MenuEntity;
import com.tableOrder.table_order.menu.model.InsertComment;
import com.tableOrder.table_order.menu.model.MenuCommentResponse;
import com.tableOrder.table_order.menu.model.MenuListResponse;
import com.tableOrder.table_order.menu.service.MenuService;
import com.tableOrder.table_order.restaurant.controller.RestaurantController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/menu")
public class MenuController {

    static Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    private final MenuService menuService;

    @GetMapping("getMenus")
    public ResponseEntity<?> getMenus(@AuthenticationPrincipal UserDetails userDetails,
                                      @RequestParam String restaurantName) {

        List<MenuListResponse> menuList = new ArrayList<>();

        for (MenuEntity menu : menuService.findByRestaurantMenus(restaurantName)) {

            MenuListResponse newMenu = MenuListResponse.builder()
                    .price(menu.getPrice())
                    .menuName(menu.getName())
                    .restaurantName(menu.getRestaurant().getName())
                    .build();

            menuList.add(newMenu);

        }
        return ResponseEntity.ok().body(menuList);
    }

    @PutMapping("putComment")
    public ResponseEntity<?> putComment(@AuthenticationPrincipal UserDetails userDetails,
                                        @RequestBody final InsertComment comment) {

        menuService.insertComment(comment.getMenuName(), comment.getRestaurant(), comment.getComment());
        return ResponseEntity.ok().build();

    }

    @GetMapping("getMenuComment")
    public ResponseEntity<?> getMenuComment(@AuthenticationPrincipal UserDetails userDetails,
                                            @RequestParam String restaurantName,
                                            @RequestParam String menuName) {

        InformationEntity information = menuService.findByMenuComment(menuName, restaurantName);

        MenuCommentResponse comment = MenuCommentResponse.builder()
                .menuName(information.getMenu().getName())
                .price(information.getMenu().getPrice())
                .comment(information.getComment())
                .build();

        return ResponseEntity.ok().body(comment);
    }

}
