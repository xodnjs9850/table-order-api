package com.tableOrder.table_order.auth.controller;


import com.tableOrder.table_order.auth.model.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("signUp")
    @ResponseBody
    public ResponseEntity<?> signUp(SignUpRequest signUpRequest) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @GetMapping("signIn")
    public ResponseEntity<?> signIn() {

        logger.error("==========test================");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
