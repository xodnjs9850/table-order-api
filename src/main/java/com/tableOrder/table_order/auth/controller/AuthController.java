package com.tableOrder.table_order.auth.controller;


import com.tableOrder.table_order.auth.model.SignInRequest;
import com.tableOrder.table_order.auth.model.SignUpRequest;
import com.tableOrder.table_order.auth.service.AuthService;
import com.tableOrder.table_order.util.TokenMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    static Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @PostMapping("signUp")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {

        return authService
                .signUp(signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getName())
                .map(response -> ResponseEntity.ok().build())
                .orElseGet(ResponseEntity.status(HttpStatus.BAD_REQUEST)::build);
    }


    @PostMapping("signIn")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {

        return authService
                .signIn(signInRequest.getEmail(), signInRequest.getPassword())
                .map(TokenMapper.INSTANCE::toSigninResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}
