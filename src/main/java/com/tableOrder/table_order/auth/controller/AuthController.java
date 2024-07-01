package com.tableOrder.table_order.auth.controller;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("signIn")
    public ResponseEntity<?> signIn() {

        logger.error("==========test================");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
