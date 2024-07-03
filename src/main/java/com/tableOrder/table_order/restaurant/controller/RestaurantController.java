package com.tableOrder.table_order.restaurant.controller;

import com.tableOrder.table_order.restaurant.model.InsertRestaurant;
import com.tableOrder.table_order.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

    static Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantService restaurantService;

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> addRestaurant(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody final InsertRestaurant insertRestaurant) {

        restaurantService.insertRestaurant(userDetails.getUsername(), insertRestaurant.getRestaurantName(), insertRestaurant.getMenuList());

        return ResponseEntity.ok().build();
    }


}
