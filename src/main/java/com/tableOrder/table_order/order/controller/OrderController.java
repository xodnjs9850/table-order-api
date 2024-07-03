package com.tableOrder.table_order.order.controller;


import com.tableOrder.table_order.order.model.InsertOrderRequest;
import com.tableOrder.table_order.order.model.UpdateOrderRequest;
import com.tableOrder.table_order.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    static Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> addOrders(@AuthenticationPrincipal UserDetails userDetails,
                                       @RequestBody final InsertOrderRequest insertOrderRequest) {
        orderService.insertOrders(userDetails.getUsername(), insertOrderRequest.getRestaurant(), insertOrderRequest.getMenus());
        return ResponseEntity.ok().build();
    }


    @PostMapping("updateOrder")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> updateOrder(@AuthenticationPrincipal UserDetails userDetails,
                                         @RequestBody final UpdateOrderRequest updateOrderRequest) {
        orderService.updateOrders(userDetails.getUsername(), updateOrderRequest.getRestaurant(), updateOrderRequest.getMenus());
        return ResponseEntity.ok().build();
    }

    @PostMapping("orderFrom")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> orderFrom(@AuthenticationPrincipal UserDetails userDetails,
                                       @RequestBody final UpdateOrderRequest updateOrderRequest) {
        return ResponseEntity.ok().build();
    }

}
